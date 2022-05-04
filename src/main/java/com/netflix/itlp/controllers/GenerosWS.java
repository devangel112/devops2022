package com.netflix.itlp.controllers;

import java.util.List;

import com.netflix.itlp.dao.GenerosJDBC;
import com.netflix.itlp.models.Generos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Hola Devops

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE, })
public class GenerosWS {
    @Autowired
    GenerosJDBC repo;

    @PostMapping
    public ResponseEntity<?> insertarGenero(@RequestBody Generos genero) {
        try {
            int id = repo.insertar(genero);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{genero-id}")
    public ResponseEntity<?> modificarGenero(@PathVariable("genero-id") int generoId, @RequestBody Generos genero) {
        try {
            repo.modificar(generoId, genero);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{genero-id}")
    public ResponseEntity<?> desactivarGenero(@PathVariable("genero-id") int generoId) {
        try {
            repo.desactivar(generoId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarGeneros() {
        try {
            List<Generos> resultado = repo.listar();
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/{genero-id}/peliculas/{pelicula-id}")
    public ResponseEntity<?> asignarGeneroPelicula(@PathVariable("genero-id") int generoId,
            @PathVariable("pelicula-id") int peliculaId) {
        try {
            repo.asignarGeneroPelicula(generoId, peliculaId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/{genero-id}/series/{serie-id}")
    public ResponseEntity<?> asignarGeneroSerie(@PathVariable("genero-id") int generoId,
            @PathVariable("serie-id") int serieId) {
        try {
            repo.asignarGeneroPelicula(generoId, serieId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
