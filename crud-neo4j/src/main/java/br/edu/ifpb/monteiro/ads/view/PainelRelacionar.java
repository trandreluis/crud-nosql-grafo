package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PainelRelacionar extends JPanel {

	private Inicio framePai;
	private JButton botaoVoltar;
	private JLabel labelPessoa;
	private JLabel labelNomePessoa;
	private JComboBox<String> comboBox;	
	
	public PainelRelacionar(Inicio framePai, String pessoa) {

		this.framePai = framePai;

		this.setBounds(0, 0, 664, 421);

		OuvintePainelRelacionar ouvinte = new OuvintePainelRelacionar(this);
		setLayout(null);
		
		labelPessoa = new JLabel("Pessoa:");
		labelPessoa.setBounds(10, 11, 46, 21);
		add(labelPessoa);
		
		labelNomePessoa = new JLabel(pessoa);
		labelNomePessoa.setBounds(66, 11, 275, 21);
		add(labelNomePessoa);
		
		botaoVoltar = new JButton("Cancelar");
		botaoVoltar.setBounds(565, 376, 89, 34);
		botaoVoltar.addActionListener(ouvinte);
		add(botaoVoltar);
		
		comboBox = new JComboBox<String>();
				
		preecherComboBox();
		
		add(comboBox);
		
	}
	
	public void preecherComboBox() {
		comboBox.setBounds(10, 57, 121, 26);
		comboBox.addItem("Pai");
		comboBox.addItem("Marido");
		comboBox.addItem("Mãe");
		comboBox.addItem("Esposa");
		comboBox.addItem("Filho");
		comboBox.addItem("Irmão");
		comboBox.addItem("Namorada(o)");

	}
	
	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}
}
