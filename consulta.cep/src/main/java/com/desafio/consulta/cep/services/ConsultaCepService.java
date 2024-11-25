package com.desafio.consulta.cep.services;

import com.desafio.consulta.cep.client.CepClient;
import com.desafio.consulta.cep.model.ComparacaoCep;
import com.desafio.consulta.cep.model.DetalhesCep;
import com.desafio.consulta.cep.model.LogConsultaCep;
import com.desafio.consulta.cep.repositories.LogRepository;
import com.desafio.consulta.cep.utils.ValidaTrataResponse;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsultaCepService {

    private final CepClient client;
    private final LogRepository repository;
    private final ValidaTrataResponse validaResponse;

    @Inject
    public ConsultaCepService(CepClient client, LogRepository repository, ValidaTrataResponse validaResponse) {
        this.client = client;
        this.repository = repository;
        this.validaResponse = validaResponse;
    }

    public DetalhesCep consultarCep(String cep) {
        var response = client.consultarDetalhesCep(cep);

        repository.salvarLog(LogConsultaCep.builder()
                        .dataHora(LocalDateTime.now())
                        .cep(cep)
                        .body(response.body())
                        .statusHttp(response.statusCode())
                .build());

        validaResponse.validarResponse(response, cep);

        Gson gson = new Gson();
        return gson.fromJson(client.consultarDetalhesCep(cep).body(), DetalhesCep.class);

    }



    public ComparacaoCep compararCeps(String cep1, String cep2) {
        var detalhesCep1 = consultarCep(cep1);
        var detalhesCep2 = consultarCep(cep2);

        return ComparacaoCep.builder()
                .cep(detalhesCep1.getCep().equals(detalhesCep2.getCep()))
                .logradouro(detalhesCep1.getLogradouro().equals(detalhesCep2.getLogradouro()))
                .bairro(detalhesCep1.getBairro().equals(detalhesCep2.getBairro()))
                .localidade(detalhesCep1.getLocalidade().equals(detalhesCep2.getLocalidade()))
                .estado(detalhesCep1.getEstado().equals(detalhesCep2.getEstado()))
                .regiao(detalhesCep1.getRegiao().equals(detalhesCep2.getRegiao()))
                .ddd(detalhesCep1.getDdd().equals(detalhesCep2.getDdd()))
                .build();
    }
}
