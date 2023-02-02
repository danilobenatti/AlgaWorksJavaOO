package exercicios;

import java.time.LocalDate;
import java.time.Month;

public class Principal {
	
	public static void main(String[] args) {
		
		var imobiliaria = new Fornecedor();
		imobiliaria.setNome("Imobiliária Negócios & Sucesso Ltda");
		var mercado = new Fornecedor();
		mercado.setNome("Mercado BomGosto S/A");
		
		var atacadista = new Cliente();
		atacadista.setNome("Bila Bila Bilu Atacadista Ltda");
		var telecom = new Cliente();
		telecom.setNome("TimTim Telecomunicações ME");
		
		var contaPagar1 = new ContaPagar();
		contaPagar1.setFornecedor(imobiliaria);
		contaPagar1.setDescricao("Aluguel de barracão comercial");
		contaPagar1.setValor(2030.45);
		contaPagar1.setDataVencimento(LocalDate.of(2023, Month.MARCH, 5));
		
		var contaPagar2 = new ContaPagar(mercado, "Compra do mês", 210.89,
				LocalDate.of(2023, Month.FEBRUARY, 20));
		
		contaPagar1.pagar();
		contaPagar2.cancelar("Produtos fora da validade");
		
		var contaReceber1 = new ContaReceber();
		contaReceber1.setCliente(atacadista);
		contaReceber1.setDescricao("Pintura industrial preventiva");
		contaReceber1.setValor(50800.64);
		contaReceber1.setDataVencimento(LocalDate.of(2023, Month.APRIL, 1));
		
		var contaReceber2 = new ContaReceber(telecom, "Manutenção rede externa",
				1200.54, LocalDate.of(2023, 2, 20));
		
		contaReceber1.receber();
		contaReceber2.cancelar("Manutenção não aprovada");
	}
	
}
