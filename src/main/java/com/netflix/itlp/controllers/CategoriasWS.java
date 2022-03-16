package com.netflix.itlp.controllers;

import java.util.List;

import com.netflix.itlp.dao.CategoriasJDBC;
import com.netflix.itlp.dao.PerfilesJDBC;
import com.netflix.itlp.models.Categorias;
import com.netflix.itlp.models.Perfiles;

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

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class CategoriasWS {
    // Categorias
    @Autowired
    CategoriasJDBC repo;

    // localhost:8181/cuentas/{cuenta-id}
    @PutMapping("/{cuenta-id}")
    public ResponseEntity<?> modificarCuenta(@PathVariable("cuenta-id") int cuentaId, @RequestBody Cuentas cuenta) {
        repo.modificarCuenta(cuentaId, cuenta);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // localhost:8181/cuentas/{cuenta-id}
    @DeleteMapping("/{cuenta-id}")
    public ResponseEntity<?> desactivarCuenta(@PathVariable("cuenta-id") int cuentaId) {
        repo.desactivar(cuentaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Perfiles
    @Autowired
    PerfilesJDBC repoPerfiles;

    // localhost:8181/cuentas/{cuenta-id}/perfiles
    @PostMapping("/{cuenta-id}/perfiles")
    public ResponseEntity<?> insertarPerfil(@PathVariable("cuenta-id") int cuentaId,
            @RequestBody Perfiles nuevo_perfil) {
        try {
            int id = repoPerfiles.insertar(cuentaId, nuevo_perfil);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // localhost:8181/cuentas/{cuenta-id}/perfiles
    @GetMapping("/{cuenta-id}/perfiles")
    public ResponseEntity<?> consultarPerfiles(@PathVariable("cuenta-id") int cuentaId) {
        try {
            List<Perfiles> resultado = repoPerfiles.listar(cuentaId);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
