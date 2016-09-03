package br.edu.ifpb.monteiro.ads.dao;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class ConnectionNeo4J {

	Driver driver = null;
	Session session = null;

	public ConnectionNeo4J() {
		criarDriver();
		criarSession();
	}

	public void criarDriver() {

		try {
			this.driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "senhacrudbd2"));
		} catch (Exception e) {
			System.out.println("Erro ao criar o driver.");
		}

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
		return session;
	}

	public static void teste() {
		Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "senhacrudbd2"));
		Session session = driver.session();

//		session.run("CREATE (a:Person {name:'ZÉ', title:'King'})");

		StatementResult result = session
				.run("MATCH (a:Person) WHERE a.name = 'ZÉ' RETURN a.name AS name, a.title AS title");

		while (result.hasNext()) {
			Record record = result.next();
			System.out.println();
			System.out.println(record.get("title").asString() + " " + record.get("name").asString());
		}

		session.close();
		driver.close();
	}

}
