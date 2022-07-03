package entities;


public class Empresa {
	public String nome, cnpj, enderecoSede, telefoneSede, inauguracao;
	public double faturamentoAnual;
	public Empresa(String nome, String cnpj, String enderecoSede, String telefoneSede, String inauguracao, double faturamentoAnual) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.enderecoSede = enderecoSede;
		this.telefoneSede = telefoneSede;
		this.inauguracao = inauguracao;
		this.faturamentoAnual = faturamentoAnual;
	}
	public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	
	

}
