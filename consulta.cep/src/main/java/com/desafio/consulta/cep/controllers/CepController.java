package com.desafio.consulta.cep.controllers;

import com.desafio.consulta.cep.model.ComparacaoCep;
import com.desafio.consulta.cep.model.DetalhesCep;
import com.desafio.consulta.cep.services.ConsultaCepService;
import jakarta.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CepController {

    private final ConsultaCepService consultarCepService;

    @Inject
    public CepController(ConsultaCepService consultarCepService) {
        this.consultarCepService = consultarCepService;
    }

    @GetMapping("endereco/{cep}")
    public ResponseEntity<DetalhesCep> consultarCep(@PathVariable String cep) {
        var response = consultarCepService.consultarCep(cep);
        return ResponseEntity.ok(response);
    }

    @GetMapping("endereco/comparar-ceps")
    public ResponseEntity<ComparacaoCep> compararCeps(@RequestParam String cep1, @RequestParam String cep2) {
        var response = consultarCepService.compararCeps(cep1, cep2);
        return ResponseEntity.ok(response);
    }
}
