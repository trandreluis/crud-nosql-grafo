package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.validacao.ValidacaoPainelPessoas;

public class OuvintePainelPessoas implements ActionListener {

	private PainelPessoas painel;
	private ValidacaoPainelPessoas validacao;
	private PessoaDao dao = new PessoaDao();
	
	public OuvintePainelPessoas(PainelPessoas painel) {
		this.painel = painel;
		this.validacao = new ValidacaoPainelPessoas(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == painel.getBotaovisualizarFamilia()) {
			botaoVisualizarRelacoes();
		}
		else if(e.getSource() == painel.getBotaoRelacionar()) {
			botaoRelacionar();
		}
		else if(e.getSource() == painel.getBotaoCadastro()) {
			botaoCadastrar();
		}
		
		else if(e.getSource() == painel.getBotaoEditar()) {
			botaoEditar();
		}
		
		else if(e.getSource() == painel.getBotaoRemover()) {
			botaoRemover();
		}
		
	}

	public void botaoCadastrar() {
		PainelCadastro painelCadastro = new PainelCadastro(painel.getFramePai());
		painel.getFramePai().trocarPainel(painelCadastro);
	}
	
	public void botaoEditar() {
		
		if(validacao.validarEdicao()) {
			JOptionPane.showMessageDialog(null, "Botao editar validado!");			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Pessoa!");
		}
		
	}
	
	public void botaoRemover() {
		if(validacao.validarRemocao()) {
			
			int linha = painel.getTabelaPessoas().getSelectedRow();
			String cpf = (String) painel.getTabelaPessoas().getValueAt(linha, 2);
			
			dao.apagar(cpf);
			
			JOptionPane.showMessageDialog(null, "Pessoa Removida com sucesso!");
			
			PainelPessoas painelPessoas = new PainelPessoas(painel.getFramePai());
			painel.getFramePai().trocarPainel(painelPessoas);
			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Pessoa!");
		}
	}
	
	public void botaoVisualizarRelacoes() {
		
		if(validacao.validarVizualizacaoRelacionamento()) {
			int linha = painel.getTabelaPessoas().getSelectedRow();
			String nome = (String) painel.getTabelaPessoas().getValueAt(linha, 0);
			String sobrenome = (String) painel.getTabelaPessoas().getValueAt(linha, 1);
			String nomeCompleto = nome+" "+sobrenome;
			
			PainelRelacoes painelRelacoes = new PainelRelacoes(painel.getFramePai(), nomeCompleto);
			painel.getFramePai().trocarPainel(painelRelacoes);			
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Pessoa!");
		}
		
	}
	
	public void botaoRelacionar() {
		if(validacao.validacaoRelacionamento()) {
			int linha = painel.getTabelaPessoas().getSelectedRow();
			String nome = (String) painel.getTabelaPessoas().getValueAt(linha, 0);
			String sobrenome = (String) painel.getTabelaPessoas().getValueAt(linha, 1);
			String nomeCompleto = nome+" "+sobrenome;
			String cpf = (String) painel.getTabelaPessoas().getValueAt(linha, 2);
			PainelRelacionar painelRelacoes = new PainelRelacionar(painel.getFramePai(), nomeCompleto, cpf);
			painel.getFramePai().trocarPainel(painelRelacoes);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Pessoa!");
		}
	}
	
	public PainelPessoas getPainel() {
		return this.painel;
	}
	
}
