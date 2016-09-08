package br.edu.ifpb.monteiro.ads.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.model.Pessoa;

@SuppressWarnings("serial")
public class PainelRelacionar extends JPanel {

	private Inicio framePai;
	private JButton botaoCancelar;
	private JButton botaoCadastrarRelacionamento;
	private JLabel labelPessoa;
	private JLabel labelNomePessoa;
	private JComboBox<String> comboBoxRelacoes;	
	private JTable tabelaPessoas;
	private String cpfPessoa;

	
	public PainelRelacionar(Inicio framePai, String nomePessoa, String cpfPessoa) {

		this.framePai = framePai;

		this.setBounds(0, 0, 664, 421);

		OuvintePainelRelacionar ouvinte = new OuvintePainelRelacionar(this);
		setLayout(null);
		
		this.cpfPessoa = cpfPessoa;
		
		labelPessoa = new JLabel("Pessoa:");
		labelPessoa.setBounds(10, 11, 46, 21);
		add(labelPessoa);
		
		labelNomePessoa = new JLabel(nomePessoa);
		labelNomePessoa.setBounds(66, 11, 275, 21);
		add(labelNomePessoa);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(565, 376, 89, 34);
		botaoCancelar.addActionListener(ouvinte);
		add(botaoCancelar);
		
		botaoCadastrarRelacionamento = new JButton("Cadastrar Relacionamento");
		botaoCadastrarRelacionamento.setBounds(380, 376, 180, 34);
		botaoCadastrarRelacionamento.addActionListener(ouvinte);
		add(botaoCadastrarRelacionamento);
		
		comboBoxRelacoes = new JComboBox<String>();
				
		preecherComboBox();
		
		montarPreencherTabela();

		JScrollPane st = new JScrollPane(tabelaPessoas);
		st.setBounds(3, 80, 658, 290);

		add(st);
		
		add(comboBoxRelacoes);
		
		JLabel lblTipoDeRelao = new JLabel("Tipo de rela\u00E7\u00E3o:");
		lblTipoDeRelao.setBounds(10, 44, 102, 16);
		add(lblTipoDeRelao);
		
	}
	
	public void preecherComboBox() {
		comboBoxRelacoes.setBounds(106, 39, 121, 26);
		comboBoxRelacoes.addItem("PAI");
		comboBoxRelacoes.addItem("MARIDO");
		comboBoxRelacoes.addItem("MAE");
		comboBoxRelacoes.addItem("ESPOSA");
		comboBoxRelacoes.addItem("FILHO");
		comboBoxRelacoes.addItem("IRMAO");
		comboBoxRelacoes.addItem("NAMORADA(O)");

	}
	
	public void montarPreencherTabela() {

		PessoaDao pd = new PessoaDao();
		
		ArrayList<Pessoa> pessoas = pd.buscarTodos();
		
		ArrayList<Pessoa> copiaSemPrincipal = new ArrayList<Pessoa>();
		
		for(Pessoa p : pessoas) {
			if(!p.getCpf().equals(cpfPessoa)) {
				copiaSemPrincipal.add(p);
			}
		}
		
		ModeloTabelaPessoa model = new ModeloTabelaPessoa(copiaSemPrincipal);
		this.tabelaPessoas = new JTable(model);

	}

	public JButton getBotaoCadastrarRelacionamento() {
		return this.botaoCadastrarRelacionamento;
	}
	
	public JButton getBotaoVoltar() {
		return botaoCancelar;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}
	
	public JComboBox<String> getComboBoxRelacao() {
		return this.comboBoxRelacoes;
	}
	
	public JTable getTabelaPessoas() {
		return this.tabelaPessoas;
	}
	
	public String getCpfSelecionado() {
		return this.cpfPessoa;
	}
	
}
