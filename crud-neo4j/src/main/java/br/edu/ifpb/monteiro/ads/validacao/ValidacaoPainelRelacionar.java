package br.edu.ifpb.monteiro.ads.validacao;

import br.edu.ifpb.monteiro.ads.view.OuvintePainelRelacionar;
import br.edu.ifpb.monteiro.ads.view.PainelRelacionar;

public class ValidacaoPainelRelacionar {

	private OuvintePainelRelacionar ouvinte;
	private PainelRelacionar painel;
	
	public ValidacaoPainelRelacionar(OuvintePainelRelacionar ouvintePainel) {
		this.ouvinte = ouvintePainel;
		this.painel = ouvintePainel.getPainel();
	}
	
	public boolean validacaoCadastrarRelacionamento() {
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
	
	public void validacaoCancelar() {
		
	}
	
}
