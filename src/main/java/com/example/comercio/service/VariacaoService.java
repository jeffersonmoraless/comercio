package com.example.comercio.service;

import com.example.comercio.repository.VariacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VariacaoService {
    @Autowired
    private VariacaoRepository variacaoRepository;


}
