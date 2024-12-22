package br.com.alura.forumhub.records;

import br.com.alura.forumhub.entity.Autor;
import br.com.alura.forumhub.entity.Curso;

import java.time.LocalDateTime;

public record DadosRetornoTopico(String título, String mensagem, LocalDateTime dataDeCriacao, boolean status, Autor autor,Curso curso) {
}
