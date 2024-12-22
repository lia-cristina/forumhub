package br.com.alura.forumhub.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosUsuarioCadastrado(@NotNull Long id, @NotNull @NotBlank String nome, @NotNull @NotBlank @Email String email) {
}
