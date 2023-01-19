/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.proyect.PruebaKevinGui.service;

import com.edu.proyect.PruebaKevinGui.model.Canciones;
import com.edu.proyect.PruebaKevinGui.repository.CancionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LENOVO
 */
public class CancionServiceImpl extends GenericServiceImpl<Canciones, Integer> implements CancionService{

    @Autowired
    CancionesRepository cancionRepository;

    @Override
    public CrudRepository<Canciones, Integer> getDao() {
        return cancionRepository;
    }

    public Canciones buscarCanciones(String nombre) {
        return cancionRepository.buscarCanciones(nombre);
    }
}