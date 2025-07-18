package com.dosideas.service;

import com.dosideas.domain.Provincia; 
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Matias Morales
 */
@SpringBootTest
public class ProvinciaServiceTest { 
    
    @Autowired
    private ProvinciaService provinciaService;
        
    @Test
    public void buscarPorId_conIdExistente_retornaProvincia() {
       Long id = 1L; 
       
       Provincia provincia = provinciaService.buscarPorId(id);
       
       assertThat(provincia).isNotNull(); 
       assertThat(provincia.getId()).isEqualTo(id); 
    } 
    
    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        Long id = 22L;

        Provincia provincia = provinciaService.buscarPorId(id);
        assertThat(provincia).isNull();
    }
    
    @Test
    public void buscarPorId_conIdNull_retornaNull() {

        Provincia provincia = provinciaService.buscarPorId(null);
        assertThat(provincia).isNull();
    }
    
    @Test
    public void buscarPorNombreExacto_conNombreExistente_retornaProvincias() {
        String nombre = "Buenos Aires"; 
       
        List<Provincia> provincias = provinciaService.buscarPorNombreExacto(nombre);
       
        assertThat(provincias).isNotNull();
        assertThat(provincias).isNotEmpty();

        assertThat(provincias).allMatch(p -> p.getNombre().equals(nombre));
    } 
    
    @Test
    public void buscarPorNombreExacto_conNombreNull_lanzaExcepcion() {
         assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> provinciaService.buscarPorNombreExacto(null));
    }
    
    @Test
    public void buscarPorNombreExcacto_conNombreCorto_lanzaExcepcion() {
         assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> provinciaService.buscarPorNombreExacto("BA"));
    }
    
    @Test
    public void buscarPorNombreGeneral_conNombreMinusculas_retornaProvincias() {
        String nombre = "buenos aires"; 
        
        List<Provincia> provincias = provinciaService.buscarPorNombreGeneral(nombre);

        assertThat(provincias).isNotNull();
        assertThat(provincias).isNotEmpty();
        assertThat(provincias).allMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }
    
    @Test
    public void buscarPorNombreGeneral_conNombreMayusculas_retornaProvincias() {
        String nombre = "BUENOS AIRES"; 
        
        List<Provincia> provincias = provinciaService.buscarPorNombreGeneral(nombre);

        assertThat(provincias).isNotNull();
        assertThat(provincias).isNotEmpty();
        assertThat(provincias).allMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    @Test
    public void buscarPorNombreGeneral_conNombreNull_lanzaExcepcion() {
         assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> provinciaService.buscarPorNombreGeneral(null));
    }
    
    @Test
    public void guardar_conProvinciaValida_laGuardaCorrectamente() {
        Provincia provincia = new Provincia();
        provincia.setNombre("Santa Fe");

        Provincia guardada = provinciaService.guardar(provincia);

        assertThat(guardada).isNotNull();
        assertThat(guardada.getNombre()).isEqualTo("Santa Fe");
    }

    @Test
    public void guardar_conProvinciaNull_lanzaExcepcion() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> provinciaService.guardar(null));
    }

    @Test
    public void guardar_conNombreNull_lanzaExcepcion() {
        Provincia provincia = new Provincia();
        provincia.setNombre(null);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> provinciaService.guardar(provincia));
    }

    @Test
    public void guardar_conNombreCorto_lanzaExcepcion() {
        Provincia provincia = new Provincia();
        provincia.setNombre("AB");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> provinciaService.guardar(provincia));
    }

}
