package br.com.zup.edu.cadastroavaliacoesaluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/{id}/avaliacoes")
public class AvaliacaoController {

    private final AlunoRepository alunoRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AlunoRepository alunoRepository, AvaliacaoRepository avaliacaoRepository) {
        this.alunoRepository = alunoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }


    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid AvaliacaoRequest avaliacaoRequest, @PathVariable Long id, UriComponentsBuilder uri){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do Aluno não encontrado"));
        Avaliacao avaliacao = avaliacaoRequest.toModel(aluno);
        avaliacaoRepository.save(avaliacao);

        URI location = uri.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
