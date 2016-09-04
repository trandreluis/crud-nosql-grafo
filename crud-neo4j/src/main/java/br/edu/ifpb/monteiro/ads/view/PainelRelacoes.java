package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PainelRelacoes extends JPanel {

	private Inicio framePai;
	private JButton botaoVoltar;
	private JLabel labelPessoa;
	private JLabel labelNomePessoa;
	
	public PainelRelacoes(Inicio framePai, String pessoa) {

		this.framePai = framePai;

		this.setBounds(0, 0, 664, 421);

		OuvintePainelRelacoes ouvinte = new OuvintePainelRelacoes(this);
		setLayout(null);
		
		labelPessoa = new JLabel("Pessoa:");
		labelPessoa.setBounds(10, 11, 46, 21);
		add(labelPessoa);
		
		labelNomePessoa = new JLabel(pessoa);
		labelNomePessoa.setBounds(66, 11, 275, 21);
		add(labelNomePessoa);
		
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(565, 376, 89, 34);
		botaoVoltar.addActionListener(ouvinte);
		add(botaoVoltar);

	}

	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}
}
