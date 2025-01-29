package br.com.desafioitau.app.repository;

import br.com.desafioitau.app.domain.models.Transacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransacaoRepository {


    public List<Transacao> transacoes = new ArrayList<>();

    public void addTransacao(Transacao transacao){
        this.transacoes.add(transacao);
    }

    
}
