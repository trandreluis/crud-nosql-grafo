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
	
	public void validacaoCadastrar() {
		
	}
	
	public void validacaoCancelar() {
		
	}
	
}
