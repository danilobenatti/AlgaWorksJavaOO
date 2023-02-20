package exercicios;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public abstract class Conta {
	
	Logger logger = Logger.getLogger("");
	
	private String descricao;
	private double valor;
	private LocalDate dataVencimento;
	
	protected Conta() {
	}
	
	protected Conta(String descricao, double valor, LocalDate dataVencimento) {
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}
	
	public void cancelar(String msg) {
		logger.info(msg);
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conta [descricao=");
		builder.append(descricao);
		builder.append(", valor=");
		builder.append(NumberFormat.getCurrencyInstance().format(valor));
		builder.append(", dataVencimento=");
		builder.append(DateTimeFormatter.ofPattern("dd/MM/yyyy")
				.format(dataVencimento));
		builder.append("]");
		return builder.toString();
	}
	
}
