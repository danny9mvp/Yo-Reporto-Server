package com.dannymvp.services;

import com.dannymvp.entities.Usuario;
import com.dannymvp.repositories.UsuarioRepository;

import java.util.Optional;

public interface UsuarioService {
    Usuario crearUsuario(Usuario nuevoUsuario);
    Optional<Usuario> buscarUsuario(String nick);
}
