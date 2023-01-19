/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.proyect.PruebaKevinGui.repository;

import com.edu.proyect.PruebaKevinGui.model.Lista_Reproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LENOVO
 */
public interface Lista_ReproduccionRepository extends JpaRepository<Lista_Reproduccion, Integer> {
@Query(value = "Select * from lista c where c.nombre = :nombre", nativeQuery = true)
    public Lista_Reproduccion buscarLista(String nombre);
}