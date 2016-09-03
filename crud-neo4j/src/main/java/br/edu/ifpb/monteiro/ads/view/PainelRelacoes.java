package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PainelRelacoes extends JPanel {

	private Inicio framePai;

	public PainelRelacoes(Inicio framePai) {

		this.framePai = framePai;

		this.setBounds(0, 0, 664, 421);

		OuvintePainelRelacoes ouvinte = new OuvintePainelRelacoes(this);
		setLayout(null);
		
		JLabel lblRelaes = new JLabel("Relações");
		lblRelaes.setBounds(299, 11, 68, 21);
		add(lblRelaes);

	}

	public Inicio getFramePai() {
		return this.framePai;
	}
}
