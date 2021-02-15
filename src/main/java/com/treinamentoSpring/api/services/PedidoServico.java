package com.treinamentoSpring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoSpring.api.entidades.Pedido;
import com.treinamentoSpring.api.repositories.PedidoRepository;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> buscarTodos() {
		return repository.findAll();
	}

	public Pedido buscarPorId(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.get();
	}

}
