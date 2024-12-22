package br.com.alura.forumhub.service;

import br.com.alura.forumhub.entity.Autor;
import br.com.alura.forumhub.entity.Curso;
import br.com.alura.forumhub.entity.Topico;
import br.com.alura.forumhub.enums.Categoria;
import br.com.alura.forumhub.records.DadosAtualizacao;
import br.com.alura.forumhub.records.DadosRetornoTopico;
import br.com.alura.forumhub.records.DadosTopico;
import br.com.alura.forumhub.repository.AutorRepository;
import br.com.alura.forumhub.repository.CursoRepository;
import br.com.alura.forumhub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    private final TopicoRepository topicoRepository;
    private final AutorRepository autorRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, AutorRepository autorRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.autorRepository = autorRepository;
        this.cursoRepository = cursoRepository;
    }

    public Optional<Topico> salvar(DadosTopico dadosTopico) {
        Autor autor = new Autor(dadosTopico.autor());
        autorRepository.save(autor);
        Curso curso = new Curso(dadosTopico.curso(), Categoria.PROGRAMACAO);
        cursoRepository.save(curso);
        Topico topico = new Topico(dadosTopico.titulo(), dadosTopico.mensagem(), autor, curso);
        topicoRepository.save(topico);
        return Optional.of(topico);
    }

    public List<Topico> todosTopicos() {
        var topicos = topicoRepository.findAll();
        if (topicos != null) {
            return topicos;
        }
        return List.of();
    }

    public DadosRetornoTopico buscaPorId(Long id) {
        var topico = topicoRepository.findById(id);

        if (!topico.isPresent()) {
            throw new IllegalArgumentException("Verifique o id do topico pois ele não existe no banco!");
        }

        var topicoPresente = topico.get();

        return new DadosRetornoTopico(topicoPresente.getTitulo(), topicoPresente.getMensagem(), topicoPresente.getDataCriacao(), topicoPresente.isStatus(), topicoPresente.getAutor(), topicoPresente.getCurso());
    }

    public DadosRetornoTopico atualizar(Long id, DadosAtualizacao dadosAtualizacao) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (!topico.isPresent()) {
            throw new IllegalArgumentException("ID invalido não existe no banco.");
        }

        var topicoVindoDaBanco = topico.get();

        topicoVindoDaBanco.setTitulo(dadosAtualizacao.titulo());
        topicoVindoDaBanco.setMensagem(dadosAtualizacao.mensagem());

        topicoRepository.save(topicoVindoDaBanco);

        return new DadosRetornoTopico(
                topicoVindoDaBanco.getTitulo(),
                topicoVindoDaBanco.getMensagem(),
                topicoVindoDaBanco.getDataCriacao(),
                topicoVindoDaBanco.isStatus(),
                topicoVindoDaBanco.getAutor(),
                topicoVindoDaBanco.getCurso()
        );
    }

    public void deletar(Long id) {
        var topicoVindoBando = topicoRepository.findById(id);

        if(!topicoVindoBando.isPresent()){
            throw new IllegalArgumentException("Id invalido ele não existe no banco!");
        }

        topicoRepository.delete(topicoVindoBando.get());

    }
}
