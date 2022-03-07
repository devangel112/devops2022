package com.netflix.itlp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.itlp.models.Actores;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class ActoresWS {

    // localhost:8181/actores/
    @PostMapping("/actores")
    public ResponseEntity<?> insertarActor(@RequestBody Actores nuevoActor) {
        try {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // localhost:8181/actores/{actor-id}
    @PutMapping("/{actor-id}")
    public ResponseEntity<?> modificarActor(@PathVariable("actor-id") int actorId,
            @RequestBody Actores actor) {
        try {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // localhost:8181/actores/{actor-id}
    @DeleteMapping("/{actor-id}")
    public ResponseEntity<?> desactivarActor(@PathVariable("actor-id") int actorId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
