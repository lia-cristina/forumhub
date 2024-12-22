package br.com.alura.forumhub.entity;

import br.com.alura.forumhub.enums.Categoria;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Deprecated
    protected Curso() {
        //Obrigatorio JPA
    }

    public Curso(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(nome, curso.nome) && Objects.equals(categoria, curso.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoria);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
