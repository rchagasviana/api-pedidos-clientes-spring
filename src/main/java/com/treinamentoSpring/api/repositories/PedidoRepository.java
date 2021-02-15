package com.treinamentoSpring.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamentoSpring.api.entidades.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
