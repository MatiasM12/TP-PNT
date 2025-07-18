package com.dosideas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción lanzada en caso de no encontrar la provincia buscada.
 *
 * Por medio de la anotación @ResponseStatus indicamos que, en caso de que esta
 * excepción sea lanzada, se le asociará el código de error NOT_FOUND (404). De
 * esta forma el cliente verá dicho error.
 * 
 * @author Matias Morales
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProvinciaNoEncontradaException extends Exception  {
    
    public ProvinciaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
