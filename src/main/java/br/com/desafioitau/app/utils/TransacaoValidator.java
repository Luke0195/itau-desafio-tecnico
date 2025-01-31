package br.com.desafioitau.app.utils;

import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.service.exceptions.TransacaoInvalidaException;
import org.springframework.stereotype.Component;

@Component
public class TransacaoValidator {

    private final Validator validator;

    public TransacaoValidator(Validator validator){
        this.validator = validator;
    }

    public void validarDataTransacao(TransacaoDto dto){
        boolean dataTransacaoValida = validator.isDateInTheFutureComparedToNow(dto.dataHora());
        if(!dataTransacaoValida) throw new TransacaoInvalidaException(String.format("Data da transação %s está no futuro" +
                ".", dto.dataHora()));
    }

    public void validarValorTransacao(TransacaoDto transacaoDto){
        boolean valorValido = validator.isGreaterThanZero(transacaoDto.valor());
        if(!valorValido) throw new TransacaoInvalidaException(String.format("Valor da transação %s é inválido. Deve ser" +
                " maior que zero.", transacaoDto.valor()));
    }
}
