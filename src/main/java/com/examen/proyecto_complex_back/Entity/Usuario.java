package com.examen.proyecto_complex_back.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "usuario", uniqueConstraints ={
@UniqueConstraint(columnNames = "username")
})
public class Usuario implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> autoridades = new HashSet<>();
        autoridades.add(new Authority(rol.getNombre_rol()));
        return autoridades;
    }
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
