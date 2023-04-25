package com.examen.proyecto_complex_back.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "usuario", uniqueConstraints ={
@UniqueConstraint(columnNames = "username")
})
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;
    @Column(name = "username")
    private String username;

    @Column(name = "pasword")
    private String pasword;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;
}
