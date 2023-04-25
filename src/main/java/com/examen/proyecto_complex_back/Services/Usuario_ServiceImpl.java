package com.examen.proyecto_complex_back.Services;

import com.examen.proyecto_complex_back.Entity.Usuario;
import com.examen.proyecto_complex_back.Repository.Usuario_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Usuario_ServiceImpl extends GenericServiceImpl<Usuario, Long> implements Usuariio_Service {
    @Autowired
    private Usuario_repository repository;
    @Override
    public CrudRepository<Usuario, Long > getDao() {

        return repository;
    }


}
