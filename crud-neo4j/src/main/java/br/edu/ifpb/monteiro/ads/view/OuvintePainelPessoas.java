package br.edu.ifpb.monteiro.ads.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class OuvintePainelPessoas implements ActionListener {

	private PainelPessoas painel;
	
	public OuvintePainelPessoas(PainelPessoas painel) {
		this.painel = painel;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == painel.getBotaovisualizarFamilia()) {
			botaoVisualizarFamilia();
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
		JOptionPane.showMessageDialog(null, "Cadastrar!");
		PainelCadastro painelCadastro = new PainelCadastro(painel.getFramePai());
		painel.getFramePai().trocarPainel(painelCadastro);
	}
	
	public void botaoEditar() {
		JOptionPane.showMessageDialog(null, "Editar!");
	}
	
	public void botaoRemover() {
		JOptionPane.showMessageDialog(null, "Remover!");
	}
	
	public void botaoVisualizarFamilia() {
		JOptionPane.showMessageDialog(null, "Visualizar Família!");
	}
	
	public void botaoRelacionar() {
		JOptionPane.showMessageDialog(null, "Relacionar!");
	}
	
	public PainelPessoas getPainel() {
		return this.painel;
	}
	
}
