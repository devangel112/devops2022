package com.netflix.itlp.controllers;

import com.netflix.itlp.dao.PerfilesJDBC;
import com.netflix.itlp.models.Perfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfiles")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class PerfilesWS {
    @Autowired
    PerfilesJDBC repo;

    // localhost:8181/cuentas/{cuenta-id}/perfiles/{perfil-id}
    @PutMapping("/{perfil-id}")
    public ResponseEntity<?> modificarPerfil(@PathVariable("perfil-id") int perfilId,
            @RequestBody Perfiles perfil) {
        try {
            repo.modificar(perfilId, perfil);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // localhost:8181/cuentas/{cuenta-id}/perfiles/{perfil-id}
    @DeleteMapping("/{perfil-id}")
    public ResponseEntity<?> desactivarPerfil(@PathVariable("perfil-id") int perfilId) {
        repo.desactivar(perfilId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
