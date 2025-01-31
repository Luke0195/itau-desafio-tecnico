package br.com.desafioitau.app.service;

import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.repository.TransacaoRepository;
import br.com.desafioitau.app.service.exceptions.TransacaoInvalidaException;
import br.com.desafioitau.app.utils.TransacaoValidator;
import br.com.desafioitau.app.utils.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;
import java.util.ArrayList;


@ExtendWith(SpringExtension.class)
class TransacaoServiceTest {


    @Mock
    private TransacaoRepository repository;

    @InjectMocks
    private TransacaoService transacaoService;

    private TransacaoDto transacaoDto;
    @Mock
    private  TransacaoValidator transacaoValidator;

    @Mock
    private Validator validator;

    @DisplayName("Deve lançar TransacaoInvalidaException quando a dataHora for futura a data atual")
    @Test
    void deveLancarTransacaoInvalidaExceptionQuandoADataHoraForPosteriorADataAtual(){
        TransacaoDto transacaoDto = new TransacaoDto(30.0, OffsetDateTime.now().plusHours(2));
        Mockito.doThrow(TransacaoInvalidaException.class).when(transacaoValidator).validarDataTransacao(transacaoDto);
        Assertions.assertThrows(TransacaoInvalidaException.class, () -> {
         transacaoService.addTransacao(transacaoDto);
        });
    }
    
    @DisplayName("Deve lançar TransacaoInvalidaException quando a valor da transação for invalido")
    @Test
    void deveLancarTransacaoInvalidaExceptionQuandoOvalorDaTransacaoForInvalido(){
        TransacaoDto transacaoDto = new TransacaoDto(0.0, OffsetDateTime.now());
        Mockito.doThrow(TransacaoInvalidaException.class).when(transacaoValidator).validarValorTransacao(transacaoDto);
        Assertions.assertThrows(TransacaoInvalidaException.class, () -> {
            transacaoService.addTransacao(transacaoDto);
        });
    }


}