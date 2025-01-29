package br.com.desafioitau.app.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransacaoDto(
        @NotNull(message = "O campo valor é obrigatório")
        @DecimalMin(value = "1.0", message = "O campo valor deve ser maior do que 0")
        Double valor,
        @NotNull(message = "O campo dataHora deve ser obrigatório")
        OffsetDateTime dataHora) {
}
