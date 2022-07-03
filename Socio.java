package entities;


public class Socio {
	String nome, cpf, telefone;
	String nascimento;
	public Socio(String nome, String cpf, String telefone, String nascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}
	@Override
	public String toString() {
		return nome + ", cpf=" + cpf + ", telefone=" + telefone + ", nascimento=" + nascimento + "]";
	}
	
	
	

}
