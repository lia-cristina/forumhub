package br.com.alura.forumhub.service;

import br.com.alura.forumhub.entity.Perfil;
import br.com.alura.forumhub.entity.Usuario;
import br.com.alura.forumhub.enums.Nivel;
import br.com.alura.forumhub.records.DadosUsuario;
import br.com.alura.forumhub.records.DadosUsuarioCadastrado;
import br.com.alura.forumhub.repository.PerfilRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public DadosUsuarioCadastrado cadastrar(DadosUsuario dadosUsuario) {
        List<Perfil> perfis = dadosUsuario.perfils()
                .stream()
                .map(p -> perfilRepository.findByNomeEqualsIgnoreCase(p.nome())
                        .orElse(new Perfil(p.nome(), Nivel.buscaPorValor(p.nivel()))))
                .toList();

        perfilRepository.saveAll(perfis);

        var senhaEnconder = passwordEncoder.encode(dadosUsuario.senha());

        var usuario = new Usuario(dadosUsuario.nome(), dadosUsuario.email(), senhaEnconder, perfis);

        usuario = usuarioRepository.save(usuario);

        return new DadosUsuarioCadastrado(usuario.getId(), usuario.getNome(), usuario.getEmail());


    }

}
