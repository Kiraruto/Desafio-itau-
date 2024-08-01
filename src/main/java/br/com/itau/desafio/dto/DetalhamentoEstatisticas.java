package br.com.itau.desafio.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Stream;

public record DetalhamentoEstatisticas(@NotNull @JsonAlias("count")
                                       Integer count,
                                       @NotNull @JsonAlias("sum")
                                       Double sum,
                                       @NotNull @JsonAlias("avg")
                                       Double avg,
                                       @NotNull @JsonAlias("min")
                                       Double min,
                                       @NotNull @JsonAlias("max")
                                       Double max) {
    public DetalhamentoEstatisticas(List<Double> dados) {
        this(dados.size(),
                dados.stream().mapToDouble(Double::doubleValue).sum(),
                dados.stream().mapToDouble(Double::doubleValue).average().orElse(0.0),
                dados.stream().mapToDouble(Double::doubleValue).min().orElse(0.0),
                dados.stream().mapToDouble(Double::doubleValue).max().orElse(0));
    }

}
