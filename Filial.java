package entities;


public class Filial extends Empresa {
	public String responsavel, endereco, inauguracao;
	public double faturamento;
	public int codigo;
	


	public Filial(String nome, String cnpj, String inauguracao,
			String responsavel, String endereco, double faturamento, int codigo) {
		super(nome, cnpj);
		this.responsavel = responsavel;
		this.endereco = endereco;
		this.faturamento = faturamento;
		this.codigo = codigo;
		this.inauguracao = inauguracao;
	}
	
	
	
	
	
	
	

}
