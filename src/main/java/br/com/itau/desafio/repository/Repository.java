package br.com.itau.desafio.repository;

import br.com.itau.desafio.domain.Transacao;
import br.com.itau.desafio.dto.DetalhamentoEstatisticas;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class Repository {
    private final List<Transacao> transacaolist = new ArrayList<>();

    public void save(Transacao transacao) {

        service(transacao);

        transacaolist.add(transacao);
    }

    public List<Transacao> findAll() {
        return new ArrayList<>(transacaolist);
    }

    public List<Transacao> deleteAll() {
        transacaolist.stream().map(l -> l.getValor()).forEach(System.out::println);
        transacaolist.clear();
        return new ArrayList<>();
    }

    public DetalhamentoEstatisticas getTransacao() {

        LocalDateTime agora = LocalDateTime.now();
        Timestamp segundosAtras60 = Timestamp.valueOf(agora.minusSeconds(60));

        List<Double> doubleListValor = new ArrayList<>();

        for (Transacao transacao : transacaolist) {
            if (transacao.getDataHora().after(segundosAtras60)) {
                doubleListValor.add(transacao.getValor());
            }
        }

        return new DetalhamentoEstatisticas(doubleListValor);
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
