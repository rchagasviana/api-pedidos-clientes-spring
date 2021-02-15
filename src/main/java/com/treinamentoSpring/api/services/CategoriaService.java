package com.treinamentoSpring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoSpring.api.entidades.Categoria;
import com.treinamentoSpring.api.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;

	public List<Categoria> buscarTodos() {
		return repositorio.findAll();
	}

	public Categoria buscarPorId(Long id) {
		Optional<Categoria> categoria = repositorio.findById(id);
		return categoria.get();
	}

}
