package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Matias Morales
 */
@Service
@Transactional
public class ProvinciaService {
    
    private final ProvinciaRepository provinciaRepository;
    
    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }
    
    public Provincia buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        return provinciaRepository.findById(id).orElse(null);
    }

    public List<Provincia> buscarPorNombreExacto(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser null");
        }
        if (nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        
        return provinciaRepository.findByNombre(nombre);
    }
    
    public List<Provincia> buscarPorNombreGeneral(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede null");
        }
        return provinciaRepository.findByNombreIgnoreCase(nombre);
    }


    public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }  
    
    public Provincia guardar(Provincia provincia) {
        if (provincia == null) {
            throw new IllegalArgumentException("La provincia no puede ser null");
        }

        if (provincia.getNombre() == null) {
            throw new IllegalArgumentException("El nombre de la provincia no puede ser null");
        }

        if (provincia.getNombre().length() < 3) {
            throw new IllegalArgumentException("El nombre de la provincia debe tener al menos 3 caracteres");
        }

        return provinciaRepository.save(provincia);
    }
    
}
