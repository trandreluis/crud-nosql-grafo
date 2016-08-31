package br.edu.ifpb.monteiro.ads.dao;

import java.util.ArrayList;

import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import br.edu.ifpb.monteiro.ads.model.Pessoa;

/**
 * 
 * Classe de operacoes basicas para obejtos Pessoa
 * 
 * @author André
 *
 */

public class PessoaDao {

	private Session session = null;

	public PessoaDao() {
		ConnectionNeo4J neo4j = new ConnectionNeo4J();
		this.session = neo4j.getSession();
	}

	public void salvar(Pessoa dado) {
		this.session.run("CREATE (a:User {name:'" + dado.getNome() + "', id:'" + dado.getId() + "'})");
	}

	public void salvarPessoa(Pessoa dado) {
		this.session.run("CREATE (a:Pessoa {nome:'" + dado.getNome() + "', id:'" + dado.getId() + "'})");
	}
	
	public void atualizar(long id, Pessoa pessoa) {

	}

	public Pessoa buscar(long id) {
		return null;
	}

	public ArrayList<Pessoa> buscarTodos() {
		return null;
	}

	public boolean verificarExistencia(Pessoa pessoa) {
		return false;
	}

	public void criarRelacionamentoUserPaiFilho(long idPai, long idFilho) {

		this.session.run("MATCH (nicholas:User) WHERE nicholas.nome = 'Nicholas Eduardo'"
				+ " MATCH (carlos:User) WHERE carlos.nome = 'Carlos Eduardo'"
				+ " CREATE (nicholas)-[:TRES]->(carlos)");

	}
	
	public void relacionamentoPessoaPorID(long idPai, long idFilho) {
		this.session.run("MATCH (filho:Pessoa) WHERE filho.nome = 'Andre Luis'"
				+ " MATCH (pai:Pessoa) WHERE pai.nome = 'Antônio'"
				+ " CREATE (filho)-[:Filho]->(pai)");
	}

	public static void main(String[] args) {

		PessoaDao c = new PessoaDao();

		Pessoa p = new Pessoa();

		p.setId(100);

		p.setNome("Antônio");

		p.setProfissao("Estudante");
		
		c.relacionamentoPessoaPorID(1, 1);

//		 c.salvarPessoa(p);

//		c.criarRelacionamentoUserPaiFilho(10, 100);

	}

}
