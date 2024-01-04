package com.example.comercio.controller;

import com.example.comercio.model.Classificacao;
import com.example.comercio.model.Produto;
import com.example.comercio.model.Variacao;
import com.example.comercio.service.ClassificacaoService;
import com.example.comercio.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    ClassificacaoService classificacaoService;
    /* ***********************************************************************
    **************************************************************************
        cadastrando somente produto, possibilitando escolher a classificação
          do produto a cadastrar passando classificacao_id por parametro

     *************************************************************************/
    @PostMapping()
    public ResponseEntity<Object> cadastraProduto(@RequestParam(value = "classificacao_id", required = false) Long classificacao_id,
                                                  @RequestBody Produto p){
        if (classificacao_id != null){
            Optional<Classificacao> classificacao = classificacaoService.buscaClassificacaoId(classificacao_id);
            if (classificacao.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body("classificação não existe");
            }
            p.setClassificacao(classificacao.get());
        }
        if (p.getVariacao() == null){
            List<Variacao> v = new ArrayList<>();
            p.setVariacao(v);
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.cadastraProduto(p));
    }


    /* ***********************************************************************
    **************************************************************************

                listando todos produtos cadastrados no banco

    *************************************************************************/


    @GetMapping()
    public ResponseEntity<List<Produto>> buscaProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscaProduto());
    }


    /* ***********************************************************************
   **************************************************************************

                buscando produtos cadastrados no banco pelo produto_id

   *************************************************************************/

    @GetMapping("/{produto_id}")
    public ResponseEntity<Object> buscaProdutoId(@PathVariable(value = "produto_id") Long produto_id){
        Optional<Produto> produto = produtoService.buscaProdutoId(produto_id);
        if (produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("produto não encontrado!!!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    /* ***********************************************************************
   **************************************************************************

        altera produto cadastrado no banco passando o produto_id para buscar
        o produto a ser alterado e possibilitando alterar a classificaçao do
        produto passando a classificacao_id por parametro

   *************************************************************************/

    @PutMapping("/{produto_id}")
    public ResponseEntity<Object> buscaProdutoId(@PathVariable(value = "produto_id") Long produto_id,
                                                 @RequestParam(value = "classificacao_id",required = false) Long classificacao_id,
                                                 @RequestBody Produto newProduto){

        Optional<Produto> p = produtoService.buscaProdutoId(produto_id);
        if (p.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("produto não encontrado!!!");
        }
        Produto produto = p.get();

        if (classificacao_id != null){
            Optional<Classificacao> c = classificacaoService.buscaClassificacaoId(classificacao_id);
            if (c.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body("Classificação não encontrada!!!");
            }
            produto.setClassificacao(c.get());
        }

        if (newProduto.getVariacao() != null){
            produto.setVariacao(newProduto.getVariacao());
        }
        if (newProduto.getNome() != null) {
            produto.setNome(newProduto.getNome());
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.cadastraProduto(produto));
    }

    /* ***********************************************************************
  **************************************************************************

                        Apaga produto do banco de dados

  *************************************************************************/
    @DeleteMapping("/{produto_id}")
    public ResponseEntity<Object> apagaProduto(@PathVariable(value = "produto_id") Long produto_id){
        Optional<Produto> p = produtoService.buscaProdutoId(produto_id);
        if (p.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Produto não encontrado!!!");
        }
        produtoService.apagaProduto(p.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto apagado com sucesso");
    }

}
