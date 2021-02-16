package com.treinamentoSpring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoSpring.api.entidades.Produto;
import com.treinamentoSpring.api.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositorio;

	public List<Produto> buscarTodos() {
		return repositorio.findAll();
	}

	public Produto buscarPorId(Long id) {
		Optional<Produto> produto = repositorio.findById(id);
		return produto.get();
	}

}
