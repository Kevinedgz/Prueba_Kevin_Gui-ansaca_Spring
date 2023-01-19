/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.proyect.PruebaKevinGui.repository;

import com.edu.proyect.PruebaKevinGui.model.Canciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LENOVO
 */
public interface CancionesRepository extends JpaRepository<Canciones, Integer> {

    @Query(value = "Select * from canciones c where c.nombre = :nombre", nativeQuery = true)
    public Canciones buscarCanciones(String nombre);
}