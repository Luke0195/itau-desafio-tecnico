package br.com.desafioitau.app.controller;

import br.com.desafioitau.app.domain.models.Transacao;
import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.repository.TransacaoRepository;
import br.com.desafioitau.app.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class TransacaoController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;


    public TransacaoController(TransacaoService transacaoService, TransacaoRepository transacaoRepository){
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping(value = "/transacao")
    public ResponseEntity<Void> addTransacao(@Valid @RequestBody TransacaoDto transacaoDto){
         transacaoService.addTransacao(transacaoDto);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes(){
        transacaoService.removeTransacao();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
