package br.com.desafioitau.app.service.exceptions;

public class TransacaoInvalidaException extends RuntimeException{

    public TransacaoInvalidaException(String message){
        super(message);
    }
}
