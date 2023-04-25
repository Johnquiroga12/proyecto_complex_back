package com.examen.proyecto_complex_back.Repository;

import com.examen.proyecto_complex_back.Entity.Rol;
import com.examen.proyecto_complex_back.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuario_repository extends JpaRepository<Usuario, Long> {
}
