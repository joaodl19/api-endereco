package com.desafio.consulta.cep.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Erro Inesperado")
public class ErroInesperadoException extends RuntimeException {
    public ErroInesperadoException(String message) {
        super(message);
    }
}
