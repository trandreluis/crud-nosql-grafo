package br.edu.ifpb.monteiro.ads.model;

/**
 * Dado generico inicial para testes
 * @author André
 *
 */

public class Dado {

	long id;
	String nome;

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
	
	public String toString() {
		return "ID: "+this.id+ ", NOME: "+this.nome;
	}
	
}
