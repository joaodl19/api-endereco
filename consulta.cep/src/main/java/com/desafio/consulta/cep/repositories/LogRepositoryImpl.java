package com.desafio.consulta.cep.repositories;

import com.desafio.consulta.cep.constants.ConstantsSqlQuery;
import com.desafio.consulta.cep.model.LogConsultaCep;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepositoryImpl implements LogRepository{

    private final JdbcTemplate jdbcTemplate;
    private String salvarLogsQuery;

    @Inject
    public LogRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.salvarLogsQuery = ConstantsSqlQuery.SALVAR_LOGS_QUERY;
    }

    @Override
    public void salvarLog(LogConsultaCep log) {
        jdbcTemplate.update(salvarLogsQuery, log.getDataHora(), log.getCep(), log.getStatusHttp(), log.getBody());
    }
}
