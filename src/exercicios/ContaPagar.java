package exercicios;

import java.time.LocalDate;

public class ContaPagar extends Conta {
	
	private Fornecedor fornecedor;
	
	public ContaPagar() {
	}
	
	public ContaPagar(Fornecedor fornecedor, String descricao, double valor,
			LocalDate dataVencimento) {
		super(descricao, valor, dataVencimento);
		this.fornecedor = fornecedor;
	}
	
	public void pagar() {
		logger.info("Conta a pagar: " + getDescricao());
	}
	
	@Override
	public void cancelar(String msg) {
		super.cancelar("Pagamento cancelado: " + msg);
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
