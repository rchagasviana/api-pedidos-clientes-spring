package com.treinamentoSpring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoSpring.api.entidades.UsuarioEntidade;
import com.treinamentoSpring.api.repositories.UsuarioRepository;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepository repository;

	public List<UsuarioEntidade> buscarTodos() {
		return repository.findAll();
	}

	public UsuarioEntidade buscarPorId(Long id) {
		Optional<UsuarioEntidade> usuario = repository.findById(id);
		return usuario.get();
	}

}
