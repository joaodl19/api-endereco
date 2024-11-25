package com.desafio.consulta.cep.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ComparacaoCep {
    private boolean cep;
    private boolean logradouro;
    private boolean bairro;
    private boolean localidade;
    private boolean estado;
    private boolean regiao;
    private boolean ddd;
}
