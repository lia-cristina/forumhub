package br.com.alura.forumhub.entity;

import br.com.alura.forumhub.enums.Nivel;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, unique = true, nullable = false)
    private String nome;
    private int nivel;


    @Deprecated
    protected Perfil() {
        //Obrigatorio JPA
    }

    public Perfil(@Nonnull @NotBlank String nome, Nivel nivel) {
        this.nome = nome;
        this.nivel = nivel.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(@Nonnull Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(@Nonnull @NotBlank String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel.getValor();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return nivel == perfil.nivel && Objects.equals(id, perfil.id) && Objects.equals(nome, perfil.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nivel);
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}