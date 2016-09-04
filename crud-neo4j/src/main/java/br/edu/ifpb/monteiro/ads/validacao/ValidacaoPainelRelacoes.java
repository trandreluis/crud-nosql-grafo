package br.edu.ifpb.monteiro.ads.validacao;

import br.edu.ifpb.monteiro.ads.view.OuvintePainelRelacoes;
import br.edu.ifpb.monteiro.ads.view.PainelRelacoes;

public class ValidacaoPainelRelacoes {

	private OuvintePainelRelacoes ouvinte;
	private PainelRelacoes painel;
	
	public ValidacaoPainelRelacoes(OuvintePainelRelacoes ouvintePainel) {
		this.ouvinte = ouvintePainel;
		this.painel = ouvintePainel.getPainel();
	}
	
	
	
	public void validacaoCancelar() {
		
	}
	
}
