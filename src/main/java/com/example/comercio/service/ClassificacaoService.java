package com.example.comercio.service;
import com.example.comercio.model.Classificacao;
import com.example.comercio.model.Produto;
import com.example.comercio.model.Variacao;
import com.example.comercio.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificacaoService {
    @Autowired
    private ClassificacaoRepository repository;

    public Classificacao cadastraClassificacao(Classificacao classificacao){
        if (!classificacao.getProduto().isEmpty()) {
            for (Produto p : classificacao.getProduto()) {
                p.setClassificacao(classificacao);
                if( !p.getVariacao().isEmpty() ){
                    for (Variacao v: p.getVariacao()){
                        v.setProduto(p);
                    }
                }
            }
        }
        return repository.save(classificacao);
    }
    public List<Classificacao> buscaClassificacao(){
        return repository.findAll();
    }
    public Optional<Classificacao> buscaClassificacaoId(Long classificacao){
        return repository.findById(classificacao);
    }
}
