package com.dannymvp.services;

import com.dannymvp.entities.Usuario;
import com.dannymvp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUsuarioService implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario) {
        return usuarioRepository.save(nuevoUsuario);
    }
    @Override
    public Optional<Usuario> buscarUsuario(String nick){
        return this.usuarioRepository.findByUsuNick(nick);
    }
}
