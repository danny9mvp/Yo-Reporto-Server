package com.dannymvp.services;

import com.dannymvp.entities.Reporte;
import com.dannymvp.repositories.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IReporteService implements ReporteService{
    @Autowired private ReporteRepository reporteRepository;

    @Override
    public List<Reporte> listarReportes() {
        return (List<Reporte>)reporteRepository.findAll();
    }

    @Override
    public List<Reporte> listarReportesPorUsuario(String nickname) {
        return null;
    }

    @Override
    public Reporte crearReporte(Reporte nuevoReporte) {
        return reporteRepository.save(nuevoReporte);
    }
}
