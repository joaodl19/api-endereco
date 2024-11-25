package com.desafio.consulta.cep.repositories;


import com.desafio.consulta.cep.model.LogConsultaCep;

public interface LogRepository {
    void salvarLog(LogConsultaCep log);
}
