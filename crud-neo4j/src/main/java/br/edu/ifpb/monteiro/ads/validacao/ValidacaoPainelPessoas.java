package br.edu.ifpb.monteiro.ads.validacao;

import javax.swing.JOptionPane;

import br.edu.ifpb.monteiro.ads.view.OuvintePainelPessoas;
import br.edu.ifpb.monteiro.ads.view.PainelPessoas;

public class ValidacaoPainelPessoas {

	private OuvintePainelPessoas ouvinte;
	private PainelPessoas painel;

	public ValidacaoPainelPessoas(OuvintePainelPessoas ouvintePainel) {
		this.ouvinte = ouvintePainel;
		this.painel = ouvintePainel.getPainel();
	}

	public boolean validacaoRelacionamento() {

		return validarSelecaoNaTabela();
		
	}

	public boolean validarVizualizacaoRelacionamento() {

		return validarSelecaoNaTabela();
		
	}

	public void validarCadastro() {

	}

	public boolean validarEdicao() {

		return validarSelecaoNaTabela();
		
	}

	public boolean validarRemocao() {

		return validarSelecaoNaTabela();
		
	}

	private boolean validarSelecaoNaTabela() {
		
		int linha = painel.getTabelaPessoas().getSelectedRow();

		if (linha == -1) {
			return false;
		} else {
			return true;
		}
		
	}
	
}
