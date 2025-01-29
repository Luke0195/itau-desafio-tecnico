package br.com.desafioitau.app.domain.models;

import java.time.OffsetDateTime;

public record Transacao(Double valor, OffsetDateTime dataHora) {

    @Override
    public Double valor() {
        return valor;
    }

    @Override
    public OffsetDateTime dataHora() {
        return dataHora;
    }
}
