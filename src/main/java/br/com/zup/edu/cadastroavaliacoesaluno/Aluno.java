package br.com.zup.edu.cadastroavaliacoesaluno;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String bootcamp;

    @Column(nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public Aluno(String nome, String email, String bootcamp) {
        this.nome = nome;
        this.email = email;
        this.bootcamp = bootcamp;
    }

    @Deprecated
    public Aluno() {
    }

    public Long getId() {
        return id;
    }
}
