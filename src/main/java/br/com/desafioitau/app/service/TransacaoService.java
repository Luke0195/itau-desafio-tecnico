package br.com.desafioitau.app.service;

import br.com.desafioitau.app.domain.models.Transacao;
import br.com.desafioitau.app.domain.usecases.transacao.AddTransacao;
import br.com.desafioitau.app.domain.usecases.transacao.RemoverTransacao;
import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.repository.TransacaoRepository;


import br.com.desafioitau.app.service.exceptions.TransacaoInvalidaException;
import br.com.desafioitau.app.utils.Validator;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService implements AddTransacao, RemoverTransacao {

    private final TransacaoRepository transacaoRepository;


    public TransacaoService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public void addTransacao(TransacaoDto transacaoDto) {
       validarDataTransacao(transacaoDto);
       validarValodTransacao(transacaoDto);
       transacaoRepository.addTransacao(Transacao.mapToEntity(transacaoDto));
    }

    @Override
    public void removeTransacao() {
        transacaoRepository.limparTranscacao();
    }


    private void validarDataTransacao(TransacaoDto dto){
        boolean dataTransacaoValida = Validator.isDateInTheFutureComparedToNow(dto.dataHora());
        if(!dataTransacaoValida) throw new TransacaoInvalidaException(String.format("Data da transação %s está no futuro" +
                ".", dto.dataHora()));
    }

    private void validarValodTransacao(TransacaoDto transacaoDto){
        boolean valorValido = Validator.isGreaterThanZero(transacaoDto.valor());
        if(!valorValido) throw new TransacaoInvalidaException(String.format("Valor da transação %s é inválido. Deve ser" +
                " maior que zero.", transacaoDto.valor()));
    }


}
