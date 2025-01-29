package br.com.desafioitau.app.controller;

import br.com.desafioitau.app.domain.models.Transacao;
import br.com.desafioitau.app.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;


    @PostMapping(value = "/transacao")
    public ResponseEntity<Void> addTransacao(@Valid @RequestBody Transacao transacao){
         transacaoService.addTransacao(transacao);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
