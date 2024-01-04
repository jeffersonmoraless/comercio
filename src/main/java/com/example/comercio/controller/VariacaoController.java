package com.example.comercio.controller;

import com.example.comercio.service.VariacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/variacao")
public class VariacaoController {
    @Autowired
    private VariacaoService variacaoService;


}
