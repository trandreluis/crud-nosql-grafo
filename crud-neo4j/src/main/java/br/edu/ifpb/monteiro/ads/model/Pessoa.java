package br.edu.ifpb.monteiro.ads.model;

/**
 * Dado generico inicial para testes
 * @author André
 *
 */

public class Pessoa {

	private long id;
	private String nome;
	private String profissao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String toString() {
		return "ID: "+this.id+ ", NOME: "+this.nome;
	}
	
}
