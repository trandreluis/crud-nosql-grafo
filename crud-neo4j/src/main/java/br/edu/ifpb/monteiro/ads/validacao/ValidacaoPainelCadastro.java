package br.edu.ifpb.monteiro.ads.validacao;

import br.edu.ifpb.monteiro.ads.view.OuvintePainelCadastro;
import br.edu.ifpb.monteiro.ads.view.PainelCadastro;

public class ValidacaoPainelCadastro {

	private OuvintePainelCadastro ouvinte;
	private PainelCadastro painel;

	public ValidacaoPainelCadastro(OuvintePainelCadastro ouvintePainel) {
		this.ouvinte = ouvintePainel;
		this.painel = ouvintePainel.getPainel();
	}

	public boolean validacaoCadastrar() {

		String nome = painel.getFieldNome().getText();
		String sobrenome = painel.getFieldSobrenome().getText();
		String idade = painel.getFieldIdade().getText();
		String cpf = painel.getFieldCPF().getText();

		if (nome == null || sobrenome == null || idade == null || cpf == null) {
			return false;
		}

		if (nome.equals("") || sobrenome.equals("") || idade.equals("") || cpf.equals("   .   .   -  ")) {
			return false;
		}

		return true;

	}

}
