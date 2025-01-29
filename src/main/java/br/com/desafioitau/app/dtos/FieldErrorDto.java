package br.com.desafioitau.app.dtos;

public record FieldErrorDto(String nome, String descricao) {
    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String descricao() {
        return descricao;
    }
}
