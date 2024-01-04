package com.example.comercio.service;

import com.example.comercio.model.ItemPedido;
import com.example.comercio.model.Produto;
import com.example.comercio.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> buscaItemPedido(){
        return itemPedidoRepository.findAll();
    }
    public ItemPedido adicionaItemPedido(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
}
