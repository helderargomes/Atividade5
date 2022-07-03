package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Colaboradores;
import entities.Empresa;
import entities.Filial;
import entities.Socio;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite os dados da empresa: ");
		System.out.print("Nome: ");
		String nome =  sc.nextLine();
		System.out.print("CNPJ: ");
		String cnpj = sc.nextLine();
		System.out.print("Endereco da sede: ");
		String enderecoSede = sc.nextLine();
		System.out.print("Telefone da sede: ");
		String telefoneSede = sc.nextLine();
		System.out.print("Data de inauguração: ");
		String inauguracao = sc.nextLine();
		System.out.print("Faturamento: ");
		double faturamentoSede = sc.nextDouble();
		
		Empresa empresa = new Empresa(nome, cnpj, enderecoSede, telefoneSede, inauguracao, faturamentoSede);
		
		System.out.print("Quantos socios a empresa possui?");
		int numeroSocios = sc.nextInt();
		List<Socio> socios = new ArrayList<>();
		
		for(int i = 0; i < numeroSocios; i++) {
			System.out.println("Digite os dados do socio:");
			System.out.print("Nome: ");
			sc.nextLine();
			String nomeSocio = sc.nextLine();
			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			System.out.print("Telefone: ");
			String telefone = sc.nextLine();
			System.out.println("Data de nascimento: ");
			String nascimento = sc.nextLine();
			socios.add(new Socio(nomeSocio, cpf, telefone, nascimento));			
		}
		System.out.print("A empresa possui filiais? (S/N)");
		char resposta = sc.next().charAt(0);
		double faturamentoFiliais = 0; 
		double menorFaturamento= 1000;
		double maiorFaturamento = 0;
		int codigoMenor = 0;
		int codigoMaior = 0;
		if(resposta == 's') {
			System.out.print("Quantas filiais a empresa possui?");
			int numeroFiliais = sc.nextInt();
			for (int i = 0; i < numeroFiliais; i++) {
				System.out.println("Digite os dados da filial " + (i+1) + ": ");
				System.out.print("Responsavel: ");
				sc.nextLine();
				String responsavel = sc.nextLine();
				System.out.print("Endereco: ");
				String endereco = sc.nextLine();
				System.out.print("Faturamento: ");
				double faturamento = sc.nextDouble();
				System.out.print("Codigo: ");
				int codigo = sc.nextInt();
				System.out.print("Data de inauguracao: ");
				sc.nextLine();
				String inauguracaoFilial = sc.nextLine();
				Filial filial_i = new Filial(empresa.nome, empresa.cnpj, inauguracaoFilial, responsavel, endereco, faturamento, codigo);
				faturamentoFiliais += faturamento;
				if(faturamento < menorFaturamento) {
					menorFaturamento = faturamento;
					codigoMenor = filial_i.codigo;
					
				}
				if(faturamento > maiorFaturamento) {
					maiorFaturamento = faturamento;
					codigoMaior = filial_i.codigo;
				}
			}			
		}
		
		System.out.print("Quantos funcionarios a empresa (sede e filiais) possui?");
		int numeroFuncionarios = sc.nextInt();
		double somaSalarios = 0;
		for(int i = 0; i < numeroFuncionarios; i++) {
			System.out.println("Digite os dados do " + (i+1) + ". funcionario: ");
			System.out.print("Matricula: ");
			int matricula = sc.nextInt();
			System.out.println("Nome: ");
			sc.nextLine();
			String nomeFuncionario = sc.nextLine();
			System.out.print("Salario Anual: ");
			double salarioAnual = sc.nextDouble();
			Colaboradores funcionario_i = new Colaboradores(matricula, nomeFuncionario, salarioAnual);
			somaSalarios += salarioAnual;			
		}
		double mediaSalarial = somaSalarios / numeroFuncionarios;
		double faturamentoAnual = empresa.faturamentoAnual + faturamentoFiliais;
		
		System.out.printf("Faturamento Anual: R$ %.2f%n", faturamentoAnual);
		if(resposta == 's') {
			System.out.printf("Filial com menor faturamento: " + codigoMenor + "(R$ %.2f)", menorFaturamento);
			System.out.println();
			System.out.printf("Filial com maior faturamento: " + codigoMaior + "(R$ %.2f)", maiorFaturamento);
		}
		System.out.println();
		System.out.printf("Media salarial: R$ %.2f%n", mediaSalarial);
		double balancoAnual = faturamentoAnual - somaSalarios;
		
		if (balancoAnual >= 0) {
			System.out.printf("Balanco Anual da empresa: R$ " + String.format("%.2f", balancoAnual) + "(POSITIVO)");
		}
		else {
			System.out.printf("Balanco Anual da empresa: R$ " + String.format("%.2f", balancoAnual) + "(NEGATIVO)");
			System.out.println();
			System.out.println("Dados dos socios:");
			for(Socio x : socios) {
				System.out.println(x);
			}
			
			
		}		
		sc.close();

	}

}
