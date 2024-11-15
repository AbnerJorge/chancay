package com.example.chancay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chancay.model.Embarcacion;
import com.example.chancay.repository.EmbarcacionRepository;

@Service
public class EmbarcacionService {
    
    @Autowired
    private EmbarcacionRepository embarcacionRepository;

    public List<Embarcacion> getEmbarcaciones() {
        return embarcacionRepository.findAll();
    }

    public Embarcacion getEmbarcacionById(Long id) {
        return embarcacionRepository.findById(id).orElse(null);
    }

    public Embarcacion createEmbarcacion (Embarcacion embarcacion) {
        return embarcacionRepository.save(embarcacion);
    }

    public Embarcacion updateEmbarcacion (Embarcacion embarcacion, Long id) {
        Embarcacion embarcacionActual = embarcacionRepository.findById(id).orElse(null);
        if (embarcacion != null) {
            embarcacionActual.setNombre(embarcacion.getNombre());
            embarcacionActual.setCapacidad(embarcacion.getCapacidad());
            embarcacionActual.setDescripcion(embarcacion.getDescripcion());
            
        }
        return embarcacionRepository.save(embarcacionActual);
    }

    public void deleteEmbarcacion(Long id) {
        embarcacionRepository.deleteById(id);
    }
}
