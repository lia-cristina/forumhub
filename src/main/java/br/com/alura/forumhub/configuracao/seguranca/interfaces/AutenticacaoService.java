package br.com.alura.forumhub.configuracao.seguranca.interfaces;

import br.com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario =  repository.findByEmail(username);

        if(!usuario.isPresent()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return usuario.get();
    }
}
