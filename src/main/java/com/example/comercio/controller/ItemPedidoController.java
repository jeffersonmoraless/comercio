package com.example.comercio.controller;

import com.example.comercio.model.ItemPedido;
import com.example.comercio.model.Produto;
import com.example.comercio.service.ItemPedidoService;
import com.example.comercio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Object> buscaItemPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.buscaItemPedido());
    }
    @PostMapping
    public ResponseEntity<Object> adicionaItemPedido(@RequestBody ItemPedido itemPedido){
       return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.adicionaItemPedido(itemPedido));
    }

}
