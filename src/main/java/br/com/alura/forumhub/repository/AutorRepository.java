package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
