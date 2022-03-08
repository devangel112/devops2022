package com.netflix.itlp.controllers;

import java.util.List;

import com.netflix.itlp.dao.ActoresJDBC;
import com.netflix.itlp.models.Actores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/actor")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class ActoresWS {

    @Autowired
    ActoresJDBC repoActores;

    // localhost:8181/actores/
    @PostMapping("/actores")
    public ResponseEntity<?> insertarActor(@RequestBody Actores nuevoActor) {
        try {
            int id = repoActores.insertar(nuevoActor);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // localhost:8181/actores/{actor-id}
    @PutMapping("/{actor-id}")
    public ResponseEntity<?> modificarActor(@PathVariable("actor-id") int actorId,
            @RequestBody Actores actor) {
        try {
            repoActores.modificar(actorId, actor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // localhost:8181/actores/{actor-id}
    @DeleteMapping("/{actor-id}")
    public ResponseEntity<?> desactivarActor(@PathVariable("actor-id") int actorId) {
        try {
            repoActores.desactivar(actorId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<?> listarActores() {
        try {
            List<Actores> resultado = repoActores.listar();
            return new ResponseEntity<List<Actores>>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
