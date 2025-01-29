package br.com.desafioitau.app.controller;

import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class TransacaoController {

    private final TransacaoService transacaoService;


    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping(value = "/transacao")
    public ResponseEntity<Void> addTransacao(@Valid @RequestBody TransacaoDto transacaoDto){
         transacaoService.addTransacao(transacaoDto);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
