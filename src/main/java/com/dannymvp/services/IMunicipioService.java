package com.dannymvp.services;

import com.dannymvp.entities.Municipio;
import com.dannymvp.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMunicipioService implements MunicipioService {
    @Autowired private MunicipioRepository municipioRepository;
    @Override
    public List<Municipio> listarMunicipios() {
        return (List<Municipio>) municipioRepository.findAll();
    }
}
