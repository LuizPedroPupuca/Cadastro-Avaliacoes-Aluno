package br.com.zup.edu.cadastroavaliacoesaluno;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid AlunoRequest alunoRequest, UriComponentsBuilder uri){
        Aluno aluno = alunoRequest.toModel();
        alunoRepository.save(aluno);

        URI location = uri.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
