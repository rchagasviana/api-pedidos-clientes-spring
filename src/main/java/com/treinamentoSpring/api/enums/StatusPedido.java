package com.treinamentoSpring.api.enums;

public enum StatusPedido {

	AGUARDANDO_PAGAMENTO(0), PAGO(1), ENVIADO(2), ENTREGUE(3), CANCELADO(4);

	private int codigo;

	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static StatusPedido valueOf(int codigo) {
		for (StatusPedido valor : StatusPedido.values()) {
			if (valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de Status inexistente!");

	}
}
