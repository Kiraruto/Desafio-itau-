package br.com.itau.desafio.controller;

import br.com.itau.desafio.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    @Autowired
    private Repository repository;

    @GetMapping
    public ResponseEntity<?> getEstatisticas() {

        var dados = repository.getTransacao();

        return ResponseEntity.status(200).body(dados);
    }
}
