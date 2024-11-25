package com.desafio.consulta.cep.utils;

import com.desafio.consulta.cep.Exceptions.BadRequestException;
import com.desafio.consulta.cep.Exceptions.ErroInesperadoException;
import com.desafio.consulta.cep.Exceptions.RecursoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
@Slf4j
@Service
public class ValidaTrataResponse {

    private final String notFoundMensagem = "CEP %s não encontrado";

    public void validarResponse(HttpResponse<String> response, String cep){
        switch (response.statusCode()){
            case 200:
                if(response.statusCode() == 200 && response.body().contains("\"erro\": \"true\"")){
                    log.info(String.format(notFoundMensagem, cep));
                    throw new RecursoNaoEncontradoException(String.format(notFoundMensagem, cep));
                }
                return;
            case 400:
                log.info("Bad request: " + response.request().uri());
                throw new BadRequestException(response.body());
            default:
                log.error("Erro inesperado: StatusCode: {} \nbody: {})", response.statusCode(), response.body());
                throw new ErroInesperadoException("StatusCode: " + response.statusCode() + "\nbody: " + response.body());
        }
    }
}
