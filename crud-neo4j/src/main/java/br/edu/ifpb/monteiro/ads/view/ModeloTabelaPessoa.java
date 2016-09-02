package br.edu.ifpb.monteiro.ads.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.ifpb.monteiro.ads.model.Pessoa;

@SuppressWarnings("serial")
public class ModeloTabelaPessoa extends AbstractTableModel {

	private ArrayList<Pessoa> linhas;
	private String[] colunas = new String[] { "Nome", "Sobrenome", "CPF", "Idade" };
	private final int nome = 0, sobrenome = 1, cpf = 2, idade = 3;

	public ModeloTabelaPessoa(ArrayList<Pessoa> pessoas) {
		this.linhas = pessoas;
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

		default:
			throw new IndexOutOfBoundsException("Indice da coluna fora dos limites");

		}

	}

	public Object getValueAt(int linha, int coluna) {

		Pessoa pessoa = linhas.get(linha);

		switch (coluna) {
		case nome:
			return pessoa.getNome();
		case sobrenome:
			return pessoa.getSobrenome();
		case cpf:
			return pessoa.getCpf();
		case idade:
			return pessoa.getIdade();
		default:
			throw new IndexOutOfBoundsException("Indice da coluna fora dos limites");
		}
	}

	public Pessoa getPessoa(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addPessoa(Pessoa pessoa) {

		linhas.add(pessoa);

		int ultimoElemento = getRowCount() - 1;

		fireTableRowsInserted(ultimoElemento, ultimoElemento);
	}

	public void remover(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

}
