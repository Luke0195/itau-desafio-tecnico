package br.com.desafioitau.app.controller;

import br.com.desafioitau.app.dtos.EstatisticaDto;
import br.com.desafioitau.app.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EstaticaController {

    private TransacaoService transacaoService;

    public EstaticaController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;

    }

    @GetMapping(value = "/estatistica")
    public ResponseEntity<EstatisticaDto> gerarEstatica(){
        EstatisticaDto estatisticaDto = transacaoService.gerarEstaticatica();
        return ResponseEntity.status(HttpStatus.OK).body(estatisticaDto);
    }
}
