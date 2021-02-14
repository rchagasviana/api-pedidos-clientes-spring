package com.treinamentoSpring.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoSpring.api.entidades.UsuarioEntidade;
import com.treinamentoSpring.api.services.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioServico servico;

	@GetMapping
	public ResponseEntity<List<UsuarioEntidade>> buscarTodos() {
		List<UsuarioEntidade> usuarios = servico.buscarTodos();
		return ResponseEntity.ok().body(usuarios);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioEntidade> buscarId(@PathVariable Long id) {
		UsuarioEntidade usuario = servico.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}

}
