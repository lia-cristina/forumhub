package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNomeEqualsIgnoreCase(String nome);
}
