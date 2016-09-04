package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;

@SuppressWarnings("serial")
public class PainelPessoas extends JPanel {

	private JButton botaoCadastrar;
	private JButton botaoEditar;
	private JButton botaoRemover;
	private JButton botaoVisualizarRelacoes;
	private JButton botaoRelacionar;
	private Inicio framePai;

	private JTable tabelaPessoas;

	public PainelPessoas(Inicio framePai) {

		this.framePai = framePai;

		setBounds(0, 0, 664, 421);
		setLayout(null);

		OuvintePainelPessoas ouvinte = new OuvintePainelPessoas(this);

		botaoVisualizarRelacoes = new JButton("Visualizar Relações");
		botaoVisualizarRelacoes.setBounds(10, 376, 138, 34);
		botaoVisualizarRelacoes.addActionListener(ouvinte);
		add(botaoVisualizarRelacoes);

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

		PessoaDao pd = new PessoaDao();
		
		ModeloTabelaPessoa model = new ModeloTabelaPessoa(pd.buscarTodos());
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
		return this.botaoVisualizarRelacoes;
	}

	public JButton getBotaoRelacionar() {
		return this.botaoRelacionar;
	}
	
	public JTable getTabelaPessoas() {
		return this.tabelaPessoas;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}

}
