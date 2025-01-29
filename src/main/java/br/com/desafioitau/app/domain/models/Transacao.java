package br.com.desafioitau.app.domain.models;

import br.com.desafioitau.app.dtos.TransacaoDto;

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

    public static Transacao mapToEntity(TransacaoDto dto){
        return new Transacao(dto.valor(), dto.dataHora());
    }
}
