package com.treinamentoSpring.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamentoSpring.api.entidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
