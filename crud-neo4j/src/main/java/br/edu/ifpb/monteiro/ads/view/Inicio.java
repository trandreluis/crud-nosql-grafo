package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Inicio extends JFrame {

	public Inicio() {

		this.setTitle("Cadastro de Famíliares");
		this.setSize(680, 460);
		
		PainelPessoas painel = new PainelPessoas();
		add(painel);

	}

}
