package com.desafio.consulta.cep.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class LogConsultaCep {
    private LocalDateTime dataHora;
    private String cep;
    private int statusHttp;
    private String body;
}
