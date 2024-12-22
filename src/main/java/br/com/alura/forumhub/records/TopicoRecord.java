package br.com.alura.forumhub.records;

public record TopicoRecord(String titulo,String mensagem,String dataCriacao,boolean status,AutorRecord autor,CursoRecord curso) {
}
