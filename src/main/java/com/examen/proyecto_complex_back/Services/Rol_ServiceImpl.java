package com.examen.proyecto_complex_back.Services;

import com.examen.proyecto_complex_back.Entity.Rol;
import com.examen.proyecto_complex_back.Repository.Rol_ropository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Rol_ServiceImpl extends GenericServiceImpl<Rol, Long> implements Rol_Service {
    @Autowired
    private Rol_ropository repository;
    @Override
    public CrudRepository<Rol, Long > getDao() {

        return repository;
    }


}
