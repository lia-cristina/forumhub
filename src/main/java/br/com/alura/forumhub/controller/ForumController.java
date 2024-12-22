package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.records.DadosAtualizacao;
import br.com.alura.forumhub.records.DadosRetornoTopico;
import br.com.alura.forumhub.records.DadosTopico;
import br.com.alura.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("forum")
public class ForumController {

    private final TopicoService topicoService;

    public ForumController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping("/topicos")
    public ResponseEntity criarTopico(@RequestBody @NotNull DadosTopico dadosTopico) {
        var topico = topicoService.salvar(dadosTopico).orElseThrow(() -> new RuntimeException("Erro ao cadastrar o topico!"));

        return ResponseEntity.ok(topico);
    }

    @GetMapping("/topicos")
    public ResponseEntity todoTopicosCriados() {
        return ResponseEntity.ok(topicoService.todosTopicos());
    }

    @GetMapping("/topicos/{id}")
    public ResponseEntity buscarTopico(@PathVariable @Valid Long id) {
        DadosRetornoTopico topico = topicoService.buscaPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/topicos/{id}")
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody DadosAtualizacao dadosAtualizacao) {

        var dadosTopicoRetorno = topicoService.atualizar(id, dadosAtualizacao);

        return ResponseEntity.ok(dadosTopicoRetorno);
    }

    @DeleteMapping("/topicos/{id}")
    public ResponseEntity deletarTopico(@PathVariable Long id){

        topicoService.deletar(id);

        return ResponseEntity.ok("Topico deletado com sucesso!");
    }


}
