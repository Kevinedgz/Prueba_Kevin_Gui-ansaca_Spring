/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.proyect.PruebaKevinGui.controllers;

import com.edu.proyect.PruebaKevinGui.model.Canciones;
import com.edu.proyect.PruebaKevinGui.service.CancionService;
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
@RequestMapping("/canciones")
public class CancionesController {
      @Autowired
    CancionService cancionService;
      
      
  @GetMapping("/listarcanciones")
    public ResponseEntity<List<Canciones>> obtenerListacli() {
        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crearcanciones")
    public ResponseEntity<Canciones> crearcli(@RequestBody Canciones canciones){
        return new ResponseEntity<>(cancionService.save(canciones), HttpStatus.CREATED);
    }

    // Elimnar cliente
    @DeleteMapping("/eliminarcanciones/{id}")
    public ResponseEntity <?> eliminarcli(@PathVariable Integer id) {
        cancionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizarcanciones/{id}")
    public ResponseEntity <Canciones> actulizarcli(@RequestBody Canciones canciones, @PathVariable Integer id) {
        Canciones ca = cancionService.findById(id);
        if (ca ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            ca.setTitulo(canciones.getTitulo());
            ca.setNombre_artista(canciones.getNombre_artista());
            ca.setAlbum(canciones.getAlbum());
            ca.setAño(canciones.getAño());
            return new ResponseEntity<>(cancionService.save(ca), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    }
