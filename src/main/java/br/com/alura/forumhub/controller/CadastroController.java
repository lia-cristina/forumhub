package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.records.DadosUsuario;
import br.com.alura.forumhub.service.UsuarioService;
import jakarta.annotation.Nonnull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
  private UsuarioService usuarioService;

    public CadastroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Nonnull DadosUsuario dadosUsuario){
      return ResponseEntity.ok(usuarioService.cadastrar(dadosUsuario));
    }

    public void alterar(){

    }

    public void remover(){

    }
}
