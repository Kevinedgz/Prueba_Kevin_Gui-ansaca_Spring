/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.proyect.PruebaKevinGui.service;

import com.edu.proyect.PruebaKevinGui.model.Lista_Reproduccion;
import com.edu.proyect.PruebaKevinGui.repository.Lista_ReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LENOVO
 */
public class Lista_ReproduccionServiceImpl extends GenericServiceImpl<Lista_Reproduccion, Integer> implements Lista_ReproduccionService{
     @Autowired
    Lista_ReproduccionRepository listareproRepository;

    @Override
    public CrudRepository<Lista_Reproduccion, Integer> getDao() {
        return listareproRepository;
    }

    public Lista_Reproduccion buscarLista(String nombre) {
        return listareproRepository.buscarLista(nombre);
    }
    
}

