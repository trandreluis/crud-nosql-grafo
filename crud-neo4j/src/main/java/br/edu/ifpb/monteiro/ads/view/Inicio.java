package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Inicio extends JFrame {

	private JPanel painelAtual;
	
	public Inicio() {

		this.setTitle("Cadastro de Familiares");
		this.setSize(680, 460);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		painelAtual = new PainelPessoas(this);
		add(painelAtual);

	}

	public void trocarPainel(JPanel novoPainel) {
		remove(painelAtual);
		add(novoPainel);
		this.painelAtual = novoPainel;
		repaint();
	}
	
}
