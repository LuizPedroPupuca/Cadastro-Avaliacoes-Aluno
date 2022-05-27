package br.com.zup.edu.cadastroavaliacoesaluno;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class AvaliacaoRequest {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "A atividade é obrigatória")
    private String atividade;

    public AvaliacaoRequest(String titulo, String atividade) {
        this.titulo = titulo;
        this.atividade = atividade;
    }

    public AvaliacaoRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAtividade() {
        return atividade;
    }

    public Avaliacao toModel(Aluno aluno){
        return new Avaliacao(titulo, atividade, aluno);
    }
}
