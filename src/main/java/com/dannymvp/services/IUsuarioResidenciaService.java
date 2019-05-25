package com.dannymvp.services;

import com.dannymvp.entities.UsuarioResidencia;
import com.dannymvp.repositories.UsuarioResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUsuarioResidenciaService implements UsuarioResidenciaService{
    @Autowired private UsuarioResidenciaRepository usuarioResidenciaRepository;
    @Override
    public UsuarioResidencia crearUsuarioResidencia(UsuarioResidencia nuevoUsuarioResidencia) {
        return usuarioResidenciaRepository.save(nuevoUsuarioResidencia);
    }
}
