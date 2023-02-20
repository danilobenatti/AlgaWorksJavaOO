package exercicios;

import java.time.LocalDate;

public class ContaReceber extends Conta {
	
	private Cliente cliente;
	
	public ContaReceber() {
	}
	
	public ContaReceber(Cliente cliente, String descricao, double valor,
			LocalDate dataVencimento) {
		super(descricao, valor, dataVencimento);
		this.cliente = cliente;
	}
	
	public void receber() {
		logger.info(
				() -> "Conta a receber: " + getDescricao() + "\n" + toString());
	}
	
	@Override
	public void cancelar(String msg) {
		super.cancelar("Recebimento cancelado: " + msg);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaReceber [cliente=");
		builder.append(cliente.getNome());
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
