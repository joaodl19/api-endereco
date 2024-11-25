package com.desafio.consulta.cep.constants;

public class ConstantsSqlQuery {

    public static final String SALVAR_LOGS_QUERY = "INSERT INTO public.logs (data_hora, cep, status_http, body) VALUES(?, ?, ?, ?);";
}
