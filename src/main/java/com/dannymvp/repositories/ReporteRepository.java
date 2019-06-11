package com.dannymvp.repositories;

import com.dannymvp.entities.Reporte;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReporteRepository extends CrudRepository<Reporte, Integer> {
    List<Reporte> findAllByUsuarioByRepoUsuario(String nick);
}
