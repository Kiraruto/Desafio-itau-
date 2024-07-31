package br.com.itau.desafio.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record DetalhamentoTransacao(@NotNull @JsonAlias("valor")
                                    Double valor,
                                    @NotNull @JsonAlias("dataHora")
                                    Timestamp dataHora) {
    public DetalhamentoTransacao(DetalhamentoTransacao dados) {
        this(dados.valor(), dados.dataHora());
    }
}
