package com.examen.proyecto_complex_back.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name = "id_rol")
    private Long id_rol;
    @Column(name = "nombre_rol")
    private String nombre_rol;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "rol")
    private List<Usuario> usuarios;

}
