package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.excecoes.NomeInvalidoException;
import br.edu.ifpb.monteiro.ads.model.Pessoa;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelCadastro;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelRelacoes;

public class OuvintePainelRelacoes implements ActionListener {

	private PainelRelacoes painel;
	private ValidacaoPainelRelacoes validador = new ValidacaoPainelRelacoes(this);
	private PessoaDao dao = new PessoaDao();

	public OuvintePainelRelacoes(PainelRelacoes painelRelacoes) {
		this.painel = painelRelacoes;
	}

	public void actionPerformed(ActionEvent e) {

		

	}

	public PainelRelacoes getPainel() {
		return this.painel;
	}

}
