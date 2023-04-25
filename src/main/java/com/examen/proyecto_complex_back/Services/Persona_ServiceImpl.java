package com.examen.proyecto_complex_back.Services;

import com.examen.proyecto_complex_back.Entity.Persona;
import com.examen.proyecto_complex_back.Repository.Persona_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Persona_ServiceImpl extends GenericServiceImpl<Persona, Long> implements Persona_Service {
    @Autowired
    private Persona_repository repository;
    @Override
    public CrudRepository<Persona, Long > getDao() {

        return repository;
    }


}
