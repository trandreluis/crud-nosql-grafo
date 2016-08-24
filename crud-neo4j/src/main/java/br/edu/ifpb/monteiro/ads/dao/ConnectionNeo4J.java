package br.edu.ifpb.monteiro.ads.dao;

import java.util.ArrayList;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import br.edu.ifpb.monteiro.ads.model.Dado;

public class ConnectionNeo4J {

	Driver driver = null;
	Session session = null;

	public void criarDriver() {

		try {
			this.driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "senhacrudbd2"));
		} catch (Exception e) {
			System.out.println("Erro ao criar o driver.");
		}

	}

	public Driver getDriver() {

		if (this.driver == null) {
			criarDriver();
		}

		return this.driver;

	}

	public void criarSession() {

		try {
			this.session = driver.session();
		} catch (Exception e) {
			System.out.println("Erro ao criar Session.");
			e.printStackTrace();
		}

	}

	public Session getSession() {

		if (session == null) {
			criarSession();
		}

		return session;

	}

	public void salvar(Dado dado) {
		if (session == null || driver == null) {
			criarDriver();
			criarSession();
		}
		this.session.run("CREATE (a:Carai {name:'" + dado.getNome() + "', id:'" + dado.getId() + "'})");
	}

	public ArrayList<Dado> recuperar(long id) {
		if (session == null || driver == null) {
			criarDriver();
			criarSession();
		}

		ArrayList<Dado> dados = new ArrayList<Dado>();

		StatementResult result = session.run("MATCH (a:Person) WHERE a.id = '" + id + "' RETURN a.nome AS nome");

		while (result.hasNext()) {
			Record record = result.next();
			Dado dadoTemp = new Dado();
			dadoTemp.setNome(record.get("nome").asString());
			dados.add(dadoTemp);
		}

		return dados;

	}

	public void teste() {
		Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "senhacrudbd2"));
		Session session = driver.session();

		session.run("CREATE (a:Person {name:'ZÉ', title:'King'})");

		StatementResult result = session
				.run("MATCH (a:Person) WHERE a.name = 'ZÉ' RETURN a.name AS name, a.title AS title");

		while (result.hasNext()) {
			Record record = result.next();
			System.out.println(record.get("title").asString() + " " + record.get("name").asString());
		}

		session.close();
		driver.close();
	}

}
