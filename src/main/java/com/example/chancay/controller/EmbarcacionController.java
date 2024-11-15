package com.example.chancay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chancay.model.Embarcacion;
import com.example.chancay.service.EmbarcacionService;

@RestController
@RequestMapping("/api/embarcacion")
public class EmbarcacionController {
    
    @Autowired
    private EmbarcacionService embarcacionService;

    //obtener lista de embarcaciones
    @GetMapping
    public List<Embarcacion> getEmbarcaciones() {
        return embarcacionService.getEmbarcaciones();
    }

    //obtener una embarcacion por id
    @GetMapping("/{id}")
    public ResponseEntity<Embarcacion> getEmbarcacionById(@PathVariable Long id) {
        Embarcacion embarcacionActual = embarcacionService.getEmbarcacionById(id);
        if (embarcacionActual != null) {
            return ResponseEntity.ok(embarcacionActual);       
        }
        return ResponseEntity.notFound().build();
    }

    //crear una embarcacion
    @PostMapping
    public Embarcacion createEmbarcacion(@RequestBody Embarcacion embarcacion) {
        return embarcacionService.createEmbarcacion(embarcacion);       
    }

    //actualizar una embarcacion
    @PostMapping("/{id}")
    public ResponseEntity<Embarcacion> updateEmbarcacion(@RequestBody Embarcacion embarcacion, @PathVariable Long id) {
        Embarcacion embarcacionActual = embarcacionService.getEmbarcacionById(id);
        if (embarcacionActual != null) {
            return ResponseEntity.ok(embarcacionActual);
        }
        return ResponseEntity.notFound().build();
    }

    //eliminar una embarcacion
    @DeleteMapping("/{id}")
    public ResponseEntity<Embarcacion> deleteEmbarcacion(@PathVariable Long id) {
        Embarcacion embarcacionActual = embarcacionService.getEmbarcacionById(id);
        if (embarcacionActual != null) {
            embarcacionService.deleteEmbarcacion(id);
            return ResponseEntity.ok(embarcacionActual);
        }
        return ResponseEntity.notFound().build();
    }
}
