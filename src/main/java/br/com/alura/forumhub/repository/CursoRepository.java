package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
