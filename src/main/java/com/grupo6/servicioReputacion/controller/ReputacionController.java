package com.grupo6.servicioReputacion.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo6.servicioReputacion.model.Reputacion;
import com.grupo6.servicioReputacion.service.ReputacionService;

@RestController
@RequestMapping(("/api/v1/reputaciones"))
public class ReputacionController {

    @Autowired
    private ReputacionService reputacionService;

    @GetMapping
    public ResponseEntity<List<Reputacion>> obtenerTodasReputaciones() {
        List<Reputacion> reputaciones = reputacionService.obtenerTodasReputaciones();
        if (reputaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reputaciones);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Reputacion>> obtenerReputacionesPorUsuario(@PathVariable Integer idUsuario) {
        List<Reputacion> reputaciones = reputacionService.obtenerReputacionesPorUsuario(idUsuario);
        if (reputaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reputaciones);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Reputacion>> obtenerReputacionesPorEstado(@RequestBody String estado) {
        List<Reputacion> reputaciones = reputacionService.obtenerReputacionesPorEstado(estado);
        if (reputaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reputaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reputacion> obtenerReputacionPorId(@PathVariable Integer id) {
        Reputacion reputacion = reputacionService.obtenerReputacionPorId(id);
        if (reputacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reputacion);
    }

    @PostMapping
    public ResponseEntity<Reputacion> guardarReputacion(@RequestBody Reputacion reputacion) {
        Reputacion nuevaReputacion = reputacionService.guardarReputacion(reputacion);
        return ResponseEntity.status(Response.SC_CREATED).body(nuevaReputacion);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Reputacion> actualizarReputacion(@PathVariable Integer id, @RequestBody Reputacion reputacion) {
        Reputacion reputacionExistente = reputacionService.obtenerReputacionPorId(id);
        if (reputacionExistente == null) {
            return ResponseEntity.notFound().build();
        }
        reputacion.setIdReputacion(id);
        Reputacion reputacionActualizada = reputacionService.guardarReputacion(reputacion);
        return ResponseEntity.ok(reputacionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReputacion(@PathVariable Integer id) {
        Reputacion reputacion = reputacionService.obtenerReputacionPorId(id);
        if (reputacion == null) {
            return ResponseEntity.notFound().build();
        }
        reputacionService.eliminarReputacion(id);
        return ResponseEntity.noContent().build();
    }



    

}
