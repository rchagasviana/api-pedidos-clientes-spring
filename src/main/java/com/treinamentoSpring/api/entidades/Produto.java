package com.treinamentoSpring.api.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imagemUrl;

	@ManyToMany
	//Criação da terceira tabela com de relacionamento m:1 com Produto e Categoria
	@JoinTable(name = "tb_produto_categoria",
	joinColumns = @JoinColumn(name = "idProduto"),
	inverseJoinColumns = @JoinColumn(name = "idCategoria")) //Se o mapeamento fosse em Categoria, o inverseJoinColumns seria idProduto
	private Set<Categoria> categorias = new HashSet<>();
	// é preciso instaciar para garantir que não comece com valor nulo. Começa
	// vazia, mas instanciada
	// garantir que um produto não tenha mais de uma ocorrência da mesma categoria

	public Produto() {
		super();
	}

	public Produto(Long id, String nome, String descricao, Double preco, String imagemUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imagemUrl = imagemUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagem(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public Set<Categoria> getCategorias() {
		return categorias;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
