package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matias Morales
 */
public interface ProvinciaRepository  extends JpaRepository<Provincia, Long> {

    public List<Provincia> findByNombre(String nombre);

    public List<Provincia> findByNombreIgnoreCase(String nombre);
    
}
