package br.com.desafioitau.app.service;

import br.com.desafioitau.app.domain.models.Transacao;
import br.com.desafioitau.app.domain.usecases.transacao.AddTransacao;
import br.com.desafioitau.app.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransacaoService implements AddTransacao {

    private final TransacaoRepository transacaoRepository;


    @Override
    public void addTransacao(Transacao transacao) {
        System.out.println(transacao);
    }
}
