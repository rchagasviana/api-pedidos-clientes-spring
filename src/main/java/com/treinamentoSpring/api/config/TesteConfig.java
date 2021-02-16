package com.treinamentoSpring.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.treinamentoSpring.api.entidades.Categoria;
import com.treinamentoSpring.api.entidades.Pedido;
import com.treinamentoSpring.api.entidades.Produto;
import com.treinamentoSpring.api.entidades.Usuario;
import com.treinamentoSpring.api.enums.StatusPedido;
import com.treinamentoSpring.api.repositories.CategoriaRepository;
import com.treinamentoSpring.api.repositories.PedidoRepository;
import com.treinamentoSpring.api.repositories.ProdutoRepository;
import com.treinamentoSpring.api.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {

		// Teste de Inserção de Usuários
		Usuario usuario01 = new Usuario(null, "Rafael", "rafael@gmail.com", "111-111", "123456");
		Usuario usuario02 = new Usuario(null, "Rafael2", "rafael02@gmail.com", "222-222", "123456");
		usuarioRepository.saveAll(Arrays.asList(usuario01, usuario02));

		// Teste de Inserção de Pedidos
		Pedido pedido01 = new Pedido(null, Instant.parse("2021-02-12T17:42:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO,
				usuario01);
		Pedido pedido02 = new Pedido(null, Instant.parse("2021-02-13T03:30:10Z"), StatusPedido.ENVIADO, usuario01);
		Pedido pedido03 = new Pedido(null, Instant.parse("2021-02-13T15:01:22Z"), StatusPedido.CANCELADO, usuario02);
		pedidoRepository.saveAll(Arrays.asList(pedido01, pedido02, pedido03));

		// Teste de Inserção de Categoria
		Categoria categoria01 = new Categoria(null, "Eletronicos");
		Categoria categoria02 = new Categoria(null, "Computadores");
		Categoria categoria03 = new Categoria(null, "Livros");
		categoriaRepository.saveAll(Arrays.asList(categoria01, categoria02, categoria03));

		// Teste de Inserção de Produtos
		Produto produto01 = new Produto(null, "Notebook", "AMD Rayzen7,4GB de RAM, SSD de 480GB", 4990.0, "");
		Produto produto02 = new Produto(null, "Smarthone", "Xiaomi, Redmi Note7", 800.00, "");
		Produto produto03 = new Produto(null, "Livro", "Deep Web-Investigação no Submundo da Internet", 40.00, "");
		produtoRepository.saveAll(Arrays.asList(produto01, produto02, produto03));
		
		//Teste de Relação - Relacionando produto a uma categoria
		produto01.getCategorias().add(categoria01);
		produto01.getCategorias().add(categoria02);
		produto02.getCategorias().add(categoria01);
		produto03.getCategorias().add(categoria03);
		produtoRepository.saveAll(Arrays.asList(produto01, produto02, produto03));
		
		
		
		
		

	}
}
