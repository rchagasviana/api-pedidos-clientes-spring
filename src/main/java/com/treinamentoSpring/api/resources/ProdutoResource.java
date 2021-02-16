package com.treinamentoSpring.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoSpring.api.entidades.Produto;
import com.treinamentoSpring.api.services.ProdutoService;

@RestController
@RequestMapping(value = "/Produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService servico;

	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> Produtos = servico.buscarTodos();
		return ResponseEntity.ok().body(Produtos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarId(@PathVariable Long id) {
		Produto Produto = servico.buscarPorId(id);
		return ResponseEntity.ok().body(Produto);
	}

}