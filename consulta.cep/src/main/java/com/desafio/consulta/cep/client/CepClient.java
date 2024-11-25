package com.desafio.consulta.cep.client;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CepClient {
    private final String url;

    @Inject
    public CepClient(@Value("${cep.api.url}") String url) {
        this.url = url;
    }

    public HttpResponse<String> consultarDetalhesCep(String cep) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/ws/" + cep + "/json"))
                .GET()
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalError("Erro ao acessar api de consulta de CEP", e);
        }
    }
}
