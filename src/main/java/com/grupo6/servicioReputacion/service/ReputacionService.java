package com.grupo6.servicioReputacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo6.servicioReputacion.model.Reputacion;
import com.grupo6.servicioReputacion.repository.ReputacionRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReputacionService {

    @Autowired
    private ReputacionRepo reputacionRepo;

    public List<Reputacion> obtenerTodasReputaciones() {
        return reputacionRepo.findAll();
    }

    public List<Reputacion> obtenerReputacionesPorUsuario(Integer idUsuario) {
        return reputacionRepo.findByUsuario(idUsuario);
    }

    public List<Reputacion> obtenerReputacionesPorEstado(String estado) {
        return reputacionRepo.findByEstado(estado);
    }

    public Reputacion obtenerReputacionPorId(Integer id) {
        return reputacionRepo.findById(id).orElse(null);
    }

    public Reputacion guardarReputacion(Reputacion reputacion) {
        return reputacionRepo.save(reputacion);
    }

    public void eliminarReputacion(Integer id) {
        reputacionRepo.deleteById(id);
    }

    

}
