package com.dannymvp.services;

import com.dannymvp.entities.Reporte;

import java.util.List;

public interface ReporteService {
    List<Reporte> listarReportes();
    List<Reporte> listarReportesPorUsuario(String nickname);
    Reporte crearReporte(Reporte nuevoReporte);
}
