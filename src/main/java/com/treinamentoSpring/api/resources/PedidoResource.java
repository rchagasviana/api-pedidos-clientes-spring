package com.treinamentoSpring.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoSpring.api.entidades.Pedido;
import com.treinamentoSpring.api.services.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoServico servico;

	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		List<Pedido> pedidos = servico.buscarTodos();
		return ResponseEntity.ok().body(pedidos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarId(@PathVariable Long id) {
		Pedido pedido = servico.buscarPorId(id);
		return ResponseEntity.ok().body(pedido);
	}

}