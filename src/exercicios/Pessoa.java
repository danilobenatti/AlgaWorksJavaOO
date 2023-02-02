package exercicios;

public abstract class Pessoa {
	
	private String nome;
	
	protected Pessoa() {
	}
	
	protected Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
