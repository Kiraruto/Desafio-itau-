package br.com.itau.desafio.controller;

import br.com.itau.desafio.domain.Transacao;
import br.com.itau.desafio.dto.DetalhamentoTransacao;
import br.com.itau.desafio.repository.TransacaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postTransacao(@RequestBody @Valid DetalhamentoTransacao dados) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            Transacao transacao = mapper.convertValue(dados, Transacao.class);

            transacaoRepository.save(transacao);

            return ResponseEntity.status(201).build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Erro ao processar a transação");
        }
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> deleteTransacao(@RequestBody @Valid DetalhamentoTransacao dados) {

        transacaoRepository.deleteAll();

        return ResponseEntity.status(200).build();
    }
}
