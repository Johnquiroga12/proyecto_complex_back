package com.examen.proyecto_complex_back.Controller;

import com.examen.proyecto_complex_back.Entity.Persona;
import com.examen.proyecto_complex_back.Entity.Usuario;
import com.examen.proyecto_complex_back.Services.Persona_Service;
import com.examen.proyecto_complex_back.Services.Usuariio_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuario")
public class Usuario_Controller {
    @Autowired
    Usuariio_Service Service;

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario r) {
        try {

            return new ResponseEntity<>(Service.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> obtenerLista() {
        try {
            return new ResponseEntity<>(Service.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(Service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return Service.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarCliente(@PathVariable Long id,@RequestBody Usuario p) {
        Usuario usu = Service.findById(id);
        if (usu == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(Service.save(usu), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}