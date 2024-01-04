package com.example.comercio.repository;

import com.example.comercio.model.Variacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariacaoRepository extends JpaRepository<Variacao,Long> {

}
