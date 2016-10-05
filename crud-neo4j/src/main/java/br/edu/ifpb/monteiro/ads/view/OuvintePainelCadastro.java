package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.model.Pessoa;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelCadastro;

public class OuvintePainelCadastro implements ActionListener {

	private PainelCadastro painel;
	private ValidacaoPainelCadastro validador;
	private PessoaDao dao = new PessoaDao();

	public OuvintePainelCadastro(PainelCadastro painel) {
		this.painel = painel;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == painel.getBotaoSalvar()) {
			botaoSalvar();
		}

		else if (e.getSource() == painel.getBotaoCancelar()) {
			botaoCancelar();
		}

	}

	public void botaoSalvar() {

		validador = new ValidacaoPainelCadastro(this);

		if (validador.validacaoCadastrar()) {

			Pessoa pessoa = new Pessoa();

			pessoa.setNome(painel.getFieldNome().getText());
			pessoa.setSobrenome(painel.getFieldSobrenome().getText());
			pessoa.setIdade(Integer.parseInt(painel.getFieldIdade().getText()));
			pessoa.setCpf(painel.getFieldCPF().getText());

			if(!painel.getFieldCPF().isEditable()) {
				dao.atualizar(pessoa);
			}
			
			else {
				dao.salvar(pessoa);				
			}
			

			JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");

			PainelPessoas painelPessoas = new PainelPessoas(painel.getFramePai());
			painelPessoas.getFramePai().trocarPainel(painelPessoas);

		}

		else {
			JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
		}

	}

	public void botaoCancelar() {

		PainelPessoas painelPessoas = new PainelPessoas(painel.getFramePai());
		painelPessoas.getFramePai().trocarPainel(painelPessoas);

	}

	public PainelCadastro getPainel() {
		return this.painel;
	}

}
