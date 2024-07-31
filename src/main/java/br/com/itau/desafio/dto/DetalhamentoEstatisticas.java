package br.com.itau.desafio.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DetalhamentoEstatisticas(@NotNull @JsonAlias("count")
                                       Long count,
                                       @NotNull @JsonAlias("sum")
                                       Double sum,
                                       @NotNull @JsonAlias("avg")
                                       Double avg,
                                       @NotNull @JsonAlias("min")
                                       Double min,
                                       @NotNull @JsonAlias("max")
                                       Double max) {
}
