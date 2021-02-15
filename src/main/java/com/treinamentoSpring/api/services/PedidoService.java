package com.treinamentoSpring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoSpring.api.entidades.Pedido;
import com.treinamentoSpring.api.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositorio;

	public List<Pedido> buscarTodos() {
		return repositorio.findAll();
	}

	public Pedido buscarPorId(Long id) {
		Optional<Pedido> pedido = repositorio.findById(id);
		return pedido.get();
	}

}
