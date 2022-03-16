package com.netflix.itlp.controllers;

import java.util.List;

import com.netflix.itlp.dao.CategoriasJDBC;
import com.netflix.itlp.models.Categorias;


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
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class CategoriasWS {
    // Categorias
    @Autowired
    CategoriasJDBC repo;

    //Modificar: localhost:8181/categorias/{categoria-id}
    @PutMapping("/{categoria-id}")
    public ResponseEntity<?> modificarCategoria(@PathVariable("categoria-id") int categoriaId, @RequestBody Categorias categoria) {
    	try {
    		repo.modificarCategoria(categoriaId, categoria);
            return new ResponseEntity<>(HttpStatus.CREATED);
    	} catch (DataAccessException e) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
        
    }

    //Descativar: localhost:8181/categorias/{categoria-id}
    @DeleteMapping("/{categoria-id}")
    public ResponseEntity<?> desactivarCategoria(@PathVariable("categoria-id") int categoriaId) {
    	try {
    		repo.desactivar(categoriaId);
            return new ResponseEntity<>(HttpStatus.OK);
    	} catch (DataAccessException e) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
        
    }

    //Listar
    @GetMapping
    public ResponseEntity<?> listarCategoria() {
    	try {
    		List<Categorias> resultado = repo.listar();
    		 return new ResponseEntity<>(HttpStatus.OK); 
    	} catch (DataAccessException e) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}    
    }
    
    //Agregar
    // localhost:8181/categorias
    @PostMapping
    public ResponseEntity<?> insertarCategoria(
            @RequestBody Categorias nueva_categoria) {
        try {
            int id = repo.insertar(nueva_categoria);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
