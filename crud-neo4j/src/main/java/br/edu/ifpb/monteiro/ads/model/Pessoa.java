package br.edu.ifpb.monteiro.ads.model;

/**
 * Dado generico inicial para testes
 * @author André
 *
 */

public class Pessoa {

	protected String nome;
	protected String sobrenome;
	protected String cpf;
	protected int idade;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String toString() {
		return "NOME: "+this.nome+", SOBRENOME: "+this.sobrenome+", CPF: "+this.cpf+", IDADE: "+this.idade;
	}
	
}
