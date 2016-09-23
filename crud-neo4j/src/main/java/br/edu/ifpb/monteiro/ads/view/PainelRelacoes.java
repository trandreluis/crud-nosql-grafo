package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.ifpb.monteiro.ads.dao.BuscaAvancada;
import br.edu.ifpb.monteiro.ads.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.model.Pessoa;
import br.edu.ifpb.monteiro.ads.model.PessoaRelacionada;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PainelRelacoes extends JPanel {

	private Inicio framePai;
	private JButton botaoVoltar;
	private JLabel labelPessoa;
	private JLabel labelNomePessoa;
	private String cpfPessoaPrincipal;
	private JTable tabelaPessoasRelacionadas;
	
	public PainelRelacoes(Inicio framePai, String pessoa, String cpfPessoaPrincipal) {

		this.framePai = framePai;

		this.cpfPessoaPrincipal = cpfPessoaPrincipal;
		
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
		
		montarPreencherTabela();
		
		JScrollPane st = new JScrollPane(tabelaPessoasRelacionadas);
		st.setBounds(3, 80, 658, 290);

		add(st);

	}

	public void montarPreencherTabela() {

		PessoaDao pd = new PessoaDao();
		
		BuscaAvancada ba = new BuscaAvancada();
		ArrayList<PessoaRelacionada> pessoas = ba.buscarRelacoes(cpfPessoaPrincipal);
		
		ArrayList<PessoaRelacionada> copiaSemPrincipal = new ArrayList<PessoaRelacionada>();
		
		for(PessoaRelacionada p : pessoas) {
			if(!p.getCpf().equals(cpfPessoaPrincipal)) {
				copiaSemPrincipal.add(p);
			}
		}
		
		ModeloTabelaPessoaRelacionada model = new ModeloTabelaPessoaRelacionada(copiaSemPrincipal);
		this.tabelaPessoasRelacionadas = new JTable(model);

	}
	
	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}

	public Inicio getFramePai() {
		return this.framePai;
	}
}
