package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
