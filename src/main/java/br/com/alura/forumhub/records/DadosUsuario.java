package br.com.alura.forumhub.records;

import java.util.List;

public record DadosUsuario(String nome, String email, String senha, List<PerfilRecord> perfils) {
}
