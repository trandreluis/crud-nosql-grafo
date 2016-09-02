package br.edu.ifpb.monteiro.ads.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.ifpb.monteiro.ads.model.Pessoa;

@SuppressWarnings("serial")
public class PainelPessoas extends JPanel {

	private JButton botaoCadastrar;
	private JButton botaoEditar;
	private JButton botaoRemover;
	private JButton botaoVisualizarFamilia;
	private JButton botaoRelacionar;
	private Inicio framePai;

	private JTable tabelaPessoas;

	public PainelPessoas(Inicio framePai) {

		this.framePai = framePai;

		setBounds(0, 0, 664, 421);
		setLayout(null);

		OuvintePainelPessoas ouvinte = new OuvintePainelPessoas(this);

		botaoVisualizarFamilia = new JButton("Visualizar Fam�lia");
		botaoVisualizarFamilia.setBounds(10, 376, 138, 34);
		botaoVisualizarFamilia.addActionListener(ouvinte);
		add(botaoVisualizarFamilia);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(367, 376, 89, 34);
		botaoCadastrar.addActionListener(ouvinte);
		add(botaoCadastrar);

		botaoEditar = new JButton("Editar");
		botaoEditar.setBounds(466, 376, 89, 34);
		botaoEditar.addActionListener(ouvinte);
		add(botaoEditar);

		botaoRemover = new JButton("Remover");
		botaoRemover.setBounds(565, 376, 89, 34);
		botaoRemover.addActionListener(ouvinte);
		add(botaoRemover);

		/**
		 * incio do teste
		 */
		montarPreencherTabela();

		JScrollPane st = new JScrollPane(tabelaPessoas);
		st.setBounds(3, 3, 658, 360);

		add(st);

		botaoRelacionar = new JButton("Relacionar");
		botaoRelacionar.setBounds(158, 376, 106, 34);
		botaoRelacionar.addActionListener(ouvinte);
		add(botaoRelacionar);
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

		ModeloTabelaPessoa model = new ModeloTabelaPessoa(p);
		this.tabelaPessoas = new JTable(model);

	}

	/**
	 * fim do teste
	 */

	public JButton getBotaoCadastro() {
		return this.botaoCadastrar;
	}

	public JButton getBotaoEditar() {
		return this.botaoEditar;
	}

	public JButton getBotaoRemover() {
		return this.botaoRemover;
	}

	public JButton getBotaovisualizarFamilia() {
		return this.botaoVisualizarFamilia;
	}

	public JButton getBotaoRelacionar() {
		return this.botaoRelacionar;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}

}
