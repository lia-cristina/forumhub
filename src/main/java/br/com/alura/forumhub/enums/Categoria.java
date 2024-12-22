package br.com.alura.forumhub.enums;

public enum Categoria {
    PROGRAMACAO("Programação"),
    BANCO_DE_DADOS("Banco de dados");

    private final String categoria;

    Categoria(String categoria) {
        this.categoria = categoria;
    }
}
