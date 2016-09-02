package br.edu.ifpb.monteiro.ads.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifpb.monteiro.ads.model.Pessoa;

@SuppressWarnings("serial")
public class PainelCadastro extends JPanel {

	private JButton botaoCadastrar;
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
	private JTextField fieldCPF;

	public PainelCadastro(Inicio framePai) {

		this.framePai = framePai;

		this.setBounds(0, 0, 664, 421);
		this.setLayout(null);

		OuvintePainelCadastro ouvinte = new OuvintePainelCadastro(this);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(455, 376, 89, 34);
		botaoCadastrar.addActionListener(ouvinte);
		add(botaoCadastrar);

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

		fieldCPF = new JTextField();
		fieldCPF.setBounds(215, 229, 142, 27);
		add(fieldCPF);
		fieldCPF.setColumns(10);

		/**
		 * incio do teste
		 */
		montarPreencherTabela();
		/**
		 * fim do teste
		 */

	}

	/**
	 * inicio do teste
	 */
	public void montarPreencherTabela() {

		ArrayList<Pessoa> p = new ArrayList<Pessoa>();

		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(19);
		pessoa.setNome("Carlos");
		pessoa.setSobrenome("Prestes");
		Pessoa pessoa9 = new Pessoa();
		pessoa9.setIdade(19);
		pessoa9.setNome("Carlos");
		pessoa9.setSobrenome("Prestes");
		pessoa9.setCpf("108.678.779-44");
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);
		p.add(pessoa9);

		Pessoa pessoa10 = new Pessoa();
		pessoa10.setIdade(19);
		pessoa10.setNome("Carlos");
		pessoa10.setSobrenome("Prestes");
		pessoa10.setCpf("234.786.99-56");
		p.add(pessoa10);

		@SuppressWarnings("unused")
		ModeloTabelaPessoa model = new ModeloTabelaPessoa(p);

	}

	/**
	 * fim do teste
	 */

	public JButton getBotaoCadastro() {
		return this.botaoCadastrar;
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

	public JTextField getFieldCPF() {
		return fieldCPF;
	}

	public JButton getBotaoCancelar() {
		return this.botaoCancelar;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}

}
