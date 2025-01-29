package br.com.desafioitau.app.service;

import br.com.desafioitau.app.domain.models.Transacao;
import br.com.desafioitau.app.domain.usecases.transacao.AddTransacao;
import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.repository.TransacaoRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
public class TransacaoService implements AddTransacao {

    private final TransacaoRepository transacaoRepository;


    public TransacaoService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }
    @Override
    public void addTransacao(TransacaoDto transacaoDto) {
        System.out.println(transacaoDto);
    }
}
