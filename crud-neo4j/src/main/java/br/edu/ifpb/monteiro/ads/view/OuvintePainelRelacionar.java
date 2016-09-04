package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelRelacoes;

public class OuvintePainelRelacionar implements ActionListener {

	private PainelRelacionar painel;
	private ValidacaoPainelRelacoes validador;
	private PessoaDao dao = new PessoaDao();

	public OuvintePainelRelacionar(PainelRelacionar painelRelacoes) {
		this.painel = painelRelacoes;
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == painel.getBotaoVoltar()) {
			botaoVoltar();
		}

	}

	public void botaoVoltar() {
		PainelPessoas painelPessoas = new PainelPessoas(painel.getFramePai());
		painelPessoas.getFramePai().trocarPainel(painelPessoas);
	}
	
	public PainelRelacionar getPainel() {
		return this.painel;
	}

}
