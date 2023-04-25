package com.examen.proyecto_complex_back.Repository;

import com.examen.proyecto_complex_back.Entity.Persona;
import com.examen.proyecto_complex_back.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Persona_repository extends JpaRepository<Persona, Long> {
}
