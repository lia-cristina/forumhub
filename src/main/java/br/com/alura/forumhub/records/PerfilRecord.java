package br.com.alura.forumhub.records;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PerfilRecord(@Nonnull @NotBlank String nome, int nivel) {
}
