package br.edu.ifpb.monteiro.ads.model;

public class PessoaRelacionada extends Pessoa {

	private String tipoRelacao;

	public String getTipoRelacao() {
		return tipoRelacao;
	}

	public void setTipoRelacao(String tipoRelacao) {
		this.tipoRelacao = tipoRelacao;
	}

	public String toString() {
		return "NOME: " + this.nome + ", SOBRENOME: " + this.sobrenome + ", CPF: " + this.cpf + ", IDADE: " + this.idade
				+ ", RELACAO: " + this.tipoRelacao;
	}

}
