package br.edu.ifpb.monteiro.ads.view;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class PainelCadastro extends JPanel {

	private JButton botaoSalvar;
	private JButton botaoCancelar;

	private Inicio framePai;
	private JLabel lblCadastroDePessoa;
	private JLabel lblNome;
	private JLabel lblSobrenome;
	private JLabel lblIdade;
	private JLabel lblCpf;
	private JTextField fieldNome;
	private JTextField fieldSobrenome;
	private JTextField fieldIdade;
	private JFormattedTextField fieldCPF;
	private OuvintePainelCadastro ouvinte;

	public PainelCadastro(Inicio framePai, String nome, String sobrenome, String idade, String cpf) {

		configurarJanela(framePai);
		adicionarComponents();
		
		fieldNome.setText(nome);
		fieldSobrenome.setText(sobrenome);
		fieldIdade.setText(idade);
		fieldCPF.setText(cpf);
		fieldCPF.setEditable(false);

	}

	public PainelCadastro(Inicio framePai) {

		configurarJanela(framePai);
		adicionarComponents();

	}

	public void configurarJanela(Inicio framePai) {
		
		this.framePai = framePai;
		this.setBounds(0, 0, 664, 421);
		this.setLayout(null);

	}

	public void adicionarComponents() {

		ouvinte = new OuvintePainelCadastro(this);

		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setBounds(455, 376, 89, 34);
		botaoSalvar.addActionListener(ouvinte);
		add(botaoSalvar);

		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(565, 376, 89, 34);
		botaoCancelar.addActionListener(ouvinte);
		add(botaoCancelar);

		lblCadastroDePessoa = new JLabel("Cadastro de Pessoa");
		lblCadastroDePessoa.setBounds(271, 11, 121, 14);
		add(lblCadastroDePessoa);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(142, 94, 46, 14);
		add(lblNome);

		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(111, 145, 71, 14);
		add(lblSobrenome);

		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(144, 187, 46, 14);
		add(lblIdade);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(150, 235, 35, 14);
		add(lblCpf);

		fieldNome = new JTextField();
		fieldNome.setBounds(215, 91, 245, 27);
		add(fieldNome);
		fieldNome.setColumns(10);

		fieldSobrenome = new JTextField();
		fieldSobrenome.setBounds(215, 139, 245, 27);
		add(fieldSobrenome);
		fieldSobrenome.setColumns(10);

		fieldIdade = new JTextField();
		fieldIdade.setBounds(215, 184, 46, 27);
		add(fieldIdade);
		fieldIdade.setColumns(10);

		try {
			fieldCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Preencha de acordo com o formato ###.###.###-##", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		fieldCPF.setBounds(215, 229, 142, 27);
		add(fieldCPF);
		fieldCPF.setColumns(10);

	}

	public JButton getBotaoSalvar() {
		return this.botaoSalvar;
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldSobrenome() {
		return fieldSobrenome;
	}

	public JTextField getFieldIdade() {
		return fieldIdade;
	}

	public JFormattedTextField getFieldCPF() {
		return fieldCPF;
	}

	public JButton getBotaoCancelar() {
		return this.botaoCancelar;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}

}
