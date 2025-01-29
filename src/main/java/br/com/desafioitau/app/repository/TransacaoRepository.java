package br.com.desafioitau.app.repository;

import br.com.desafioitau.app.domain.models.Transacao;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransacaoRepository {


    public List<Transacao> transacoes = new ArrayList<>();

    public void addTransacao(Transacao transacao){
        this.transacoes.add(transacao);
    }

    public List<Transacao> getTransaction(){
        return transacoes;
    }

    public void limparTranscacao(){
        this.transacoes.clear();
    }

    public  List<Transacao> filtarListaPorMinuto(){
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime umMinutoAtras = agora.minusMinutes(1);
        return transacoes
                .stream()
                .filter(transacao -> !transacao.dataHora().isBefore(OffsetDateTime.from(umMinutoAtras))
                        && !transacao.dataHora().isAfter(OffsetDateTime.from(agora))).toList();

    }

}
