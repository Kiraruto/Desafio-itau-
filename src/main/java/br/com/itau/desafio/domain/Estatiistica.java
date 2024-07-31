package br.com.itau.desafio.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Estatiistica {
    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;
}
