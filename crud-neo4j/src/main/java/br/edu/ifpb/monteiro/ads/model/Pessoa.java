package br.edu.ifpb.monteiro.ads.model;

/**
 * Dado generico inicial para testes
 * @author Andr�
 *
 */

public class Pessoa {

	private long idPessoa;
	private String nome;
	private String sobrenome;
	private String profissao;
	private int idade;
	
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public long getIdPessoa() {
		return idPessoa;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
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
		return "ID: "+this.idPessoa+ ", NOME: "+this.nome+", SOBRENOME: "+this.sobrenome+", IDADE: "+this.idade;
	}
	
}