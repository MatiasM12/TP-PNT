package com.dosideas.controller.rest;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.ProvinciaNoEncontradaException;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Matias Morales
 */
@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRestController {
    
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/{id}")
    public Provincia buscarPorId(@PathVariable Long id) throws ProvinciaNoEncontradaException {
        Provincia provincia = provinciaService.buscarPorId(id);
        if (provincia == null) {
            throw new ProvinciaNoEncontradaException("Provincia no encontrado");
        }
        return provincia;
    }
    
    @PostMapping
    public ResponseEntity<Provincia> crearProvincia(@RequestBody Provincia provincia) {
        Provincia creada = provinciaService.guardar(provincia);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }
}
