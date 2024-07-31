package br.com.itau.desafio.repository;

import br.com.itau.desafio.domain.Transacao;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoRepository {
    private final List<Transacao> transacaolist = new ArrayList<>();

    public void save(Transacao transacao) {

        service(transacao);

        transacaolist.add(transacao);
    }

    public List<Transacao> findAll() {
        return new ArrayList<>(transacaolist);
    }

    public List<Transacao> deleteAll() {
        transacaolist.clear();
        return new ArrayList<>();
    }

    private ResponseEntity<?> service(Transacao transacao) {

        if (transacao.getDataHora().after(Timestamp.valueOf(LocalDateTime.now()))) {
            return ResponseEntity.status(422).build();
        }

        if (transacao.getValor() < 0.0) {
            return ResponseEntity.status(422).build();
        }

        return ResponseEntity.ok().build();
    }
}
