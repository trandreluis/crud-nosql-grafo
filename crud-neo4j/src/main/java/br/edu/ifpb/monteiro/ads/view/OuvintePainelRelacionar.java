package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelRelacionar;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelRelacoes;

public class OuvintePainelRelacionar implements ActionListener {

	private PainelRelacionar painel;
	private ValidacaoPainelRelacionar validador;
	private PessoaDao dao = new PessoaDao();

	public OuvintePainelRelacionar(PainelRelacionar painelRelacoes) {
		this.painel = painelRelacoes;
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == painel.getBotaoCadastrarRelacionamento()) {
			botaoCadatrarRelacionamento();
		}
		
		if(e.getSource() == painel.getBotaoVoltar()) {
			botaoVoltar();
		}

	}

	public void botaoCadatrarRelacionamento() {
		
		validador = new ValidacaoPainelRelacionar(this);
		
		if(validador.validacaoCadastrarRelacionamento()) {
			int linha = painel.getTabelaPessoas().getSelectedRow();
			String cpfFilho = (String) painel.getTabelaPessoas().getValueAt(linha, 2);
			String tipoRelacao = (String) painel.getComboBoxRelacao().getSelectedItem();
			dao.criarRelacionamento(painel.getCpfSelecionado(), cpfFilho, tipoRelacao);
			JOptionPane.showMessageDialog(null, "Relação cadastrarda com sucesso!");
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Pessoa!");
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
