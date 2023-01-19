/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.proyect.PruebaKevinGui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENOVO
 */
@Getter
@Setter
@Entity
@Table(name = "canciones")
public class Canciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancion")
    private Integer id_cancion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "nombre_artista")
    private String nombre_artista;
    @Column(name = "album")
    private String album;
    @Column(name = "año")
    private String año;
    @JsonIgnore
    @OneToMany( mappedBy = "canciones")
    private List<Lista_Reproduccion> lista_reproduccion;

    
}
