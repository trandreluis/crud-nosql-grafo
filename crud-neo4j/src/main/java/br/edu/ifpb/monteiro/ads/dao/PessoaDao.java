package br.edu.ifpb.monteiro.ads.dao;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.exceptions.ClientException;
import br.edu.ifpb.monteiro.ads.model.Pessoa;
import br.edu.ifpb.monteiro.ads.model.PessoaRelacionada;

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

	public void salvar(Pessoa pessoa) {

		Transaction transacao = session.beginTransaction();

		try {
			transacao.run("CREATE (a:Pessoa {name: '" + pessoa.getNome() + "', nome:'" + pessoa.getNome()
					+ "', sobrenome:'" + pessoa.getSobrenome() + "', cpf:'" + pessoa.getCpf() + "', idade:'"
					+ pessoa.getIdade() + "'})");
			transacao.success();
		} finally {
			try {
				transacao.close();
			} catch(ClientException excep) {
				transacao.failure();
				transacao.close();
			}
		}

		session.close();
		
	}

	public ArrayList<Pessoa> buscarTodos() {

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		StatementResult resultado = session.run(
				"MATCH (a:Pessoa) RETURN a.nome AS nome, a.sobrenome AS sobrenome, a.cpf AS cpf, a.idade AS idade");

		while (resultado.hasNext()) {

			Record pessoaAtual = resultado.next();

			Pessoa pessoaTemporaria = new Pessoa();
			pessoaTemporaria.setNome(pessoaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaAtual.get("idade").asString()));

			pessoas.add(pessoaTemporaria);

		}

		session.close();

		return pessoas;

	}

	public ArrayList<PessoaRelacionada> buscarIrmaos(String cpfPrincipal) {

		ArrayList<PessoaRelacionada> relacionados = new ArrayList<PessoaRelacionada>();

		StatementResult resultado = session
				.run("MATCH p=(pe:Pessoa)-[r:IRMAO]->() WHERE pe.cpf='" + cpfPrincipal + "' RETURN r");

		while (resultado.hasNext()) {

			Record pessoaRelacionadaAtual = resultado.next();

			System.out.println(pessoaRelacionadaAtual.size());
			List<Value> valores = pessoaRelacionadaAtual.values();
			System.out.println(valores.getClass());
			System.out.println(valores.get(0));

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			// pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			// pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			// pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			// pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			// pessoaTemporaria.setTipoRelacao("IRMAO");

			relacionados.add(pessoaTemporaria);

		}

		session.close();

		return relacionados;

	}

	public static void main(String[] args) {

//		PessoaDao pd = new PessoaDao();
//
//		ArrayList<PessoaRelacionada> pr = pd.buscarIrmaos("108.942.734-42");
//
		// for(PessoaRelacionada prt : pr) {
		// System.out.println(prt.toString());
//		 }

	}

	public boolean verificarExistencia(Pessoa pessoa) {
		return false;
	}

	public void criarRelacionamento(String cpfNoPrincipal, String cpfNoSecundario, String tipoRelacao) {

		Transaction transacao = session.beginTransaction();

		try {
			transacao.run(
					"MATCH (p1:Pessoa) WHERE p1.cpf = '" + cpfNoSecundario + "'" + " MATCH (p2:Pessoa) WHERE p2.cpf = '"
							+ cpfNoPrincipal + "'" + " CREATE (p1)-[:" + tipoRelacao + "]->(p2)");
			transacao.success();
		} finally {
			try {
				transacao.close();
			} catch(ClientException excep) {
				transacao.failure();
				transacao.close();
			}
		}

		session.close();
		
	}

	public void apagar(String cpf) {

		Transaction transacao = session.beginTransaction();

		try {
			transacao.run("MATCH (p:Pessoa) WHERE p.cpf = '" + cpf + "' DELETE p");
			transacao.success();
		} finally {
			try {
				transacao.close();
			} catch(ClientException excep) {
				transacao.failure();
				transacao.close();
			}
		}

		session.close();
		
	}

	public void apagarRelacionamento() {
		this.session.run("MATCH (filho)-[rel:FILHO]->(pai) WHERE filho.cpf = '111.119.090-90'"
				+ " AND pai.cpf = '108.942.734-42' DELETE rel");
	}

}
