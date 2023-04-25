package com.examen.proyecto_complex_back.Controller;

import com.examen.proyecto_complex_back.Entity.Persona;
import com.examen.proyecto_complex_back.Entity.Rol;
import com.examen.proyecto_complex_back.Services.Persona_Service;
import com.examen.proyecto_complex_back.Services.Rol_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/rol")
public class Rol_Controller {
    @Autowired
    Rol_Service Service;

    @PostMapping("/crear")
    public ResponseEntity<Rol> crear(@RequestBody Rol r) {
        try {

            return new ResponseEntity<>(Service.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> obtenerLista() {
        try {
            return new ResponseEntity<>(Service.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Rol> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(Service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestBody Rol rol) {
        return Service.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarCliente(@PathVariable Long id,@RequestBody Rol p) {
        Rol rol = Service.findById(id);
        if (rol == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(Service.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}