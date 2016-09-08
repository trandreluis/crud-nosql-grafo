package br.edu.ifpb.monteiro.ads.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.edu.ifpb.monteiro.ads.model.PessoaRelacionada;

@SuppressWarnings("serial")
public class ModeloTabelaPessoaRelacionada extends AbstractTableModel {

	private ArrayList<PessoaRelacionada> linhas;
	private String[] colunas = new String[] { "Nome", "Sobrenome", "CPF", "Idade", "Relacionamento" };
	private final int nome = 0, sobrenome = 1, cpf = 2, idade = 3, relacionamento = 4;

	public ModeloTabelaPessoaRelacionada(ArrayList<PessoaRelacionada> pessoasRelacionadas) {
		this.linhas = pessoasRelacionadas;
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public int getRowCount() {
		return linhas.size();
	}

	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public Class<?> getColumnClass(int indiceColuna) {

		switch (indiceColuna) {

		case nome:
			return String.class;

		case sobrenome:
			return String.class;
			
		case cpf:
			return String.class;

		case idade:
			return int.class;
			
		case relacionamento:
			return String.class;

		default:
			throw new IndexOutOfBoundsException("Indice da coluna fora dos limites");

		}

	}

	public Object getValueAt(int linha, int coluna) {

		PessoaRelacionada pessoaRelacionada = linhas.get(linha);

		switch (coluna) {
		case nome:
			return pessoaRelacionada.getNome();
		case sobrenome:
			return pessoaRelacionada.getSobrenome();
		case cpf:
			return pessoaRelacionada.getCpf();
		case idade:
			return pessoaRelacionada.getIdade();
		case relacionamento:
			return pessoaRelacionada.getTipoRelacao();
		default:
			throw new IndexOutOfBoundsException("Indice da coluna fora dos limites");
		}
	}

	public PessoaRelacionada getPessoa(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addPessoa(PessoaRelacionada pessoa) {

		linhas.add(pessoa);

		int ultimoElemento = getRowCount() - 1;

		fireTableRowsInserted(ultimoElemento, ultimoElemento);
	}

	public void remover(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

}
