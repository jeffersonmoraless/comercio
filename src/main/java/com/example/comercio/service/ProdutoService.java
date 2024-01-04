package com.example.comercio.service;

import com.example.comercio.model.Produto;
import com.example.comercio.model.Variacao;
import com.example.comercio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;
    public Produto cadastraProduto(Produto p){
        for (Variacao v: p.getVariacao()){
            v.setProduto(p);
        }
        return repository.save(p);
    }
    public List<Produto> buscaProduto(){
        return repository.findAll();
    }

    public Optional<Produto> buscaProdutoId(Long produto_id){
        return repository.findById(produto_id);
    }

    public void apagaProduto(Produto produto){
        repository.delete(produto);
    }



}
