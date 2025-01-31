package br.com.desafioitau.app.service;

import br.com.desafioitau.app.domain.models.Transacao;
import br.com.desafioitau.app.domain.usecases.transacao.AddTransacao;
import br.com.desafioitau.app.domain.usecases.transacao.RemoverTransacao;
import br.com.desafioitau.app.dtos.EstatisticaDto;
import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.repository.TransacaoRepository;


import br.com.desafioitau.app.service.exceptions.TransacaoInvalidaException;
import br.com.desafioitau.app.utils.TransacaoValidator;
import br.com.desafioitau.app.utils.Validator;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransacaoService implements AddTransacao, RemoverTransacao {

    private final TransacaoRepository transacaoRepository;
    private final Validator validator;
    private final TransacaoValidator transacaoValidator;


    public TransacaoService(TransacaoRepository transacaoRepository, Validator validator, TransacaoValidator transacaoValidator){
        this.transacaoRepository = transacaoRepository;
        this.validator = validator;
        this.transacaoValidator = transacaoValidator;

    }

    @Override
    public void addTransacao(TransacaoDto transacaoDto) {
       transacaoValidator.validarDataTransacao(transacaoDto);
       transacaoValidator.validarValorTransacao(transacaoDto);
       transacaoRepository.addTransacao(Transacao.mapToEntity(transacaoDto));
    }

    @Override
    public void removeTransacao() {
        transacaoRepository.limparTranscacao();
    }

    public EstatisticaDto gerarEstaticatica(){
        List<Transacao> transacaos = transacaoRepository.filtarListaPorMinuto();
        return this.gerarEstatica(transacaos);
    }


    private EstatisticaDto gerarEstatica(List<Transacao> transacaos){
        DoubleSummaryStatistics statistics = transacaos.stream().mapToDouble(Transacao::valor).summaryStatistics();
         Long count = statistics.getCount();
         double sum = statistics.getSum();
         double avg = statistics.getAverage();
         double min = Double.isInfinite(statistics.getMin()) ? 0.0 : statistics.getMin();
         double max =  Double.isInfinite(statistics.getMax()) ? 0.0 : statistics.getMax();
         return new EstatisticaDto(count, sum, avg, min,max);
    }


}
