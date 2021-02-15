package com.treinamentoSpring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoSpring.api.entidades.Usuario;
import com.treinamentoSpring.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;

	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.get();
	}

}
