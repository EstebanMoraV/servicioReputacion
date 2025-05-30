package com.grupo6.servicioReputacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo6.servicioReputacion.model.Reputacion;

@Repository
public interface ReputacionRepo extends JpaRepository<Reputacion, Integer> {

}
