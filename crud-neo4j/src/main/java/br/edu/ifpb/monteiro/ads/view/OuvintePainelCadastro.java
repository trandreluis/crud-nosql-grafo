package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.excecoes.NomeInvalidoException;
import br.edu.ifpb.monteiro.ads.model.Pessoa;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelCadastro;

public class OuvintePainelCadastro implements ActionListener {

	private PainelCadastro painel;
	private ValidacaoPainelCadastro validador = new ValidacaoPainelCadastro(this);
	private PessoaDao dao = new PessoaDao();

	public OuvintePainelCadastro(PainelCadastro painel) {
		this.painel = painel;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == painel.getBotaoCadastro()) {
			botaoCadastrar();
		}

		else if (e.getSource() == painel.getBotaoCancelar()) {
			botaoCancelar();
		}

	}

	public void botaoCadastrar() {

		try {
			validador.validacaoCadastrar(painel.getFieldNome().getText(), painel.getFieldSobrenome().getText(),
					painel.getFieldIdade().getText(), painel.getFieldCPF().getText());
		} catch (NomeInvalidoException e) {
			JOptionPane.showMessageDialog(null, "Nome inváilido");
		}

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(painel.getFieldNome().getText());
		pessoa.setSobrenome(painel.getFieldSobrenome().getText());
		pessoa.setIdade(Integer.parseInt(painel.getFieldIdade().getText()));
		pessoa.setCpf(painel.getFieldCPF().getText());

		dao.salvar(pessoa);

		JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
		
		PainelPessoas painelPessoas = new PainelPessoas(painel.getFramePai());
		painelPessoas.getFramePai().trocarPainel(painelPessoas);
		
	}

	public void botaoCancelar() {
		PainelPessoas painelPessoas = new PainelPessoas(painel.getFramePai());
		painelPessoas.getFramePai().trocarPainel(painelPessoas);
	}

	public PainelCadastro getPainel() {
		return this.painel;
	}

}
