package com.example.comercio.controller;

import com.example.comercio.model.Classificacao;
import com.example.comercio.model.Produto;
import com.example.comercio.service.ClassificacaoService;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classificacao")
public class ClassificacaoController {

    @Autowired
    ClassificacaoService classificacaoService;
    @PostMapping
    public ResponseEntity<Classificacao> cadastraClassificacao(@RequestBody Classificacao classificacao){
        if (classificacao.getProduto() == null){
            List<Produto> p =new ArrayList<>();
                classificacao.setProduto(p);
        }
        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.cadastraClassificacao(classificacao));
    }
    @Transactional
    @PutMapping("{classificacao_id}")
    public ResponseEntity<Object> atualizaClassificacao(@PathVariable(value = "classificacao_id") Long classificacao_id,
                                                        @RequestBody Classificacao newClassificacao){
        Optional<Classificacao> resultClassificacao = classificacaoService.buscaClassificacaoId(classificacao_id);

        if(resultClassificacao.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("classificação não encontrada!!!");
        }
        Classificacao classificacao = resultClassificacao.get();
        classificacao.setDescricao(newClassificacao.getDescricao());

        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.cadastraClassificacao(classificacao));

    }
    @GetMapping
    public ResponseEntity<List<Classificacao>> buscaClassificacao(){
        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.buscaClassificacao());
    }
}
