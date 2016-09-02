package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.model.Pessoa;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelCadastro;

public class OuvintePainelCadastro implements ActionListener {

	private PainelCadastro painel;
	private ValidacaoPainelCadastro validador = new ValidacaoPainelCadastro(this);
//	private PessoaDao dao = new PessoaDao();
	
	public OuvintePainelCadastro(PainelCadastro painel) {
		this.painel = painel;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == painel.getBotaoCadastro()) {
			botaoCadastrar();
		}
		
		else if(e.getSource() == painel.getBotaoCancelar()) {
			botaoCancelar();
		}
		
	}

	public void botaoCadastrar() {

		validador.validacaoCadastrar();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(painel.getFieldNome().getText());
		pessoa.setSobrenome(painel.getFieldSobrenome().getText());
		pessoa.setIdade(Integer.parseInt(painel.getFieldIdade().getText()));
		pessoa.setCpf(painel.getFieldCPF().getText());
		
		JOptionPane.showMessageDialog(null, pessoa);
		
	}
	
	public void botaoCancelar() {
		PainelPessoas painelPessoas = new PainelPessoas(painel.getFramePai());
		painelPessoas.getFramePai().trocarPainel(painelPessoas);
	}
	
	public PainelCadastro getPainel() {
		return this.painel;
	}
	
}
