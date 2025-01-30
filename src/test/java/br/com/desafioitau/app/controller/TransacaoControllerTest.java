package br.com.desafioitau.app.controller;


import br.com.desafioitau.app.dtos.TransacaoDto;
import br.com.desafioitau.app.service.TransacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.OffsetDateTime;

@SpringBootTest
@AutoConfigureMockMvc
class TransacaoControllerTest {


    private TransacaoDto transacaoDto;
    @InjectMocks
    private TransacaoService transacaoService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;


    @DisplayName("POST - Deve retornar 400 se o valor da transação for nulo.")
    @Test
    void deveRetornarBadRequestQuandoOValorDaTransacaoForNulo() throws Exception{
        TransacaoDto requestDto = new TransacaoDto(null, OffsetDateTime.now());
        String jsonBody = objectMapper.writeValueAsString(requestDto);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/transacao")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @DisplayName("POST - Deve retornar 400 se o valor da transação for negativo")
    @Test
    void deveRetornarBadRequestQuandoOValorDaTransacaoForNegativo() throws Exception{
        TransacaoDto requestDto = new TransacaoDto(-30.50, OffsetDateTime.now());
        String jsonBody = objectMapper.writeValueAsString(requestDto);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/transacao")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());

    }


}