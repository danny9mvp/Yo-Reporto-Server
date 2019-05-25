package com.dannymvp.repositories;

import com.dannymvp.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Optional<Usuario> findByUsuNick(String nick);
}
