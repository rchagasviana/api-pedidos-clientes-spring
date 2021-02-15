package com.treinamentoSpring.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoSpring.api.entidades.Categoria;
import com.treinamentoSpring.api.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService servico;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		List<Categoria> categoria = servico.buscarTodos();
		return ResponseEntity.ok().body(categoria);
	}
	


}
