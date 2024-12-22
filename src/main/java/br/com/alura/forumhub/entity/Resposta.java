package br.com.alura.forumhub.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 1000)
    private String mensagem;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @Deprecated
    protected Resposta() {
        //Obrigatorio JPA
    }

    public Resposta(@Nonnull @NotBlank String mensagem, @Nonnull Topico topico) {
        this.mensagem = mensagem;
        this.topico = topico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(@Nonnull @NotBlank String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(@Nonnull Topico topico) {
        this.topico = topico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resposta resposta = (Resposta) o;
        return Objects.equals(id, resposta.id) && Objects.equals(mensagem, resposta.mensagem) && Objects.equals(topico, resposta.topico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mensagem, topico);
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "id=" + id +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
