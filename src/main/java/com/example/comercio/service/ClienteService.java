package com.example.comercio.service;

import com.example.comercio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
   @Autowired
   private ClienteRepository repository;
}
