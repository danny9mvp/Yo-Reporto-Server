package com.dannymvp.services;

import com.dannymvp.entities.Departamento;
import com.dannymvp.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDepartamentoService implements DepartamentoService {
    @Autowired private DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> listarDepartamentos() {
        return (List<Departamento>)departamentoRepository.findAll();
    }
}
