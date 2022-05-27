package br.com.zup.edu.cadastroavaliacoesaluno;

import javax.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String atividade;

    @ManyToOne(optional = false)
    private Aluno aluno;

    public Avaliacao(String titulo, String atividade, Aluno aluno) {
        this.titulo = titulo;
        this.atividade = atividade;
        this.aluno = aluno;
    }

    @Deprecated
    public Avaliacao() {
    }

    public Long getId() {
        return id;
    }
}
