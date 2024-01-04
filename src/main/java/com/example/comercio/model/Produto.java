package com.example.comercio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_produto")
    private String nome;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classificacao_id")
    private Classificacao classificacao;
    @OneToMany(mappedBy = "produto" )
    @Cascade(CascadeType.ALL)
    private List<Variacao> variacao;
    public List<Variacao> getVariacao() {
        return variacao;
    }

    public void setVariacao(List<Variacao> variacao) {
        this.variacao = variacao;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
}
