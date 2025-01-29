package br.com.desafioitau.app.domain.usecases.transacao;

import br.com.desafioitau.app.dtos.TransacaoDto;

public interface AddTransacao {

    void addTransacao(TransacaoDto dto);
}
