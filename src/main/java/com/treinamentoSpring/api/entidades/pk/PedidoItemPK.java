package com.treinamentoSpring.api.entidades.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.treinamentoSpring.api.entidades.Pedido;
import com.treinamentoSpring.api.entidades.Produto;

/*Classe utilizada para "armazenamento das chaves primárias compostas"
 * Relacionamento origem -> m:n entre produto e pedido
 * */
/*Em um relacionamento m:n obrigatoriamente surge uma terceira classe que
 * relaciona-se em um relacionamento m:1 (ManyToOne) com as classes que a originaram.
 * Quando esta terceira entidade possui atributos próprios(não somente as chaves estrangeiras
 * das entidades-mãe), faz-se necessária a criação de uma classe para repreentar
 * tal entidade e guardar as chaves estrangeiras que serão primárias também juntamente
 * com os atributos próprios da classe. Nesse caso, usa-se a notação
 * @Embeddable do Jpa identificar tal classe.
 * */

@Embeddable
public class PedidoItemPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItemPK other = (PedidoItemPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

}
