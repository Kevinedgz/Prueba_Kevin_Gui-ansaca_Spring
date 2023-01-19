/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.proyect.PruebaKevinGui.controllers;

import com.edu.proyect.PruebaKevinGui.model.Canciones;
import com.edu.proyect.PruebaKevinGui.model.Lista_Reproduccion;
import com.edu.proyect.PruebaKevinGui.service.CancionService;
import com.edu.proyect.PruebaKevinGui.service.Lista_ReproduccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/listare")
public class Lista_ReproduccionController {
     @Autowired
    Lista_ReproduccionService lista_ReproduccionService;
      
      
  @GetMapping("/listarre")
    public ResponseEntity<List<Lista_Reproduccion>> obtenerListacli() {
        return new ResponseEntity<>(lista_ReproduccionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crearre")
    public ResponseEntity<Lista_Reproduccion> crearcli(@RequestBody Lista_Reproduccion listareproduccion){
        return new ResponseEntity<>(lista_ReproduccionService.save(listareproduccion), HttpStatus.CREATED);
    }

    // Elimnar cliente
    @DeleteMapping("/eliminarre/{id}")
    public ResponseEntity <?> eliminarcli(@PathVariable Integer id) {
        lista_ReproduccionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizarre/{id}")
    public ResponseEntity <Lista_Reproduccion> actulizarcli(@RequestBody Lista_Reproduccion listareproduccion, @PathVariable Integer id) {
        Lista_Reproduccion rep = lista_ReproduccionService.findById(id);
        if (rep ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            rep.setNombre(listareproduccion.getNombre());
            rep.setDescripcion(listareproduccion.getNombre());
            rep.setConjunto_canciones(listareproduccion.getDescripcion());
            
            return new ResponseEntity<>(lista_ReproduccionService.save(rep), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    }

