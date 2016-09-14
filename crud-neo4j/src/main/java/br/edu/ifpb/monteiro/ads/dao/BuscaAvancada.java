package br.edu.ifpb.monteiro.ads.dao;

import java.util.ArrayList;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import br.edu.ifpb.monteiro.ads.model.PessoaRelacionada;

/**
 * 
 * Classe de operacoes basicas para obejtos Pessoa
 * 
 * @author André
 *
 */

public class BuscaAvancada {

	private Session session = null;

	public BuscaAvancada() {
		ConnectionNeo4J neo4j = new ConnectionNeo4J();
		this.session = neo4j.getSession();
	}

	public ArrayList<PessoaRelacionada> buscarPai(ArrayList<PessoaRelacionada> pessoasRelacionadas,
			String cpfPrincipal) {

		StatementResult resultadoPai = session.run("MATCH (usu {cpf: '" + cpfPrincipal
				+ "'})-[:PAI]-(irm) RETURN irm.nome AS nome, irm.sobrenome AS sobrenome, irm.cpf AS cpf, irm.idade AS idade");

		while (resultadoPai.hasNext()) {

			Record pessoaRelacionadaAtual = resultadoPai.next();

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			pessoaTemporaria.setTipoRelacao("PAI");

			pessoasRelacionadas.add(pessoaTemporaria);

		}

		return pessoasRelacionadas;

	}

	public ArrayList<PessoaRelacionada> buscarMarido(ArrayList<PessoaRelacionada> pessoasRelacionadas,
			String cpfPrincipal) {

		StatementResult resultadoPai = session.run("MATCH (usu {cpf: '" + cpfPrincipal
				+ "'})-[:MARIDO]-(irm) RETURN irm.nome AS nome, irm.sobrenome AS sobrenome, irm.cpf AS cpf, irm.idade AS idade");

		while (resultadoPai.hasNext()) {

			Record pessoaRelacionadaAtual = resultadoPai.next();

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			pessoaTemporaria.setTipoRelacao("MARIDO");

			pessoasRelacionadas.add(pessoaTemporaria);

		}

		return pessoasRelacionadas;

	}

	public ArrayList<PessoaRelacionada> buscarMae(ArrayList<PessoaRelacionada> pessoasRelacionadas,
			String cpfPrincipal) {

		StatementResult resultadoMae = session.run("MATCH (usu {cpf: '" + cpfPrincipal
				+ "'})-[:MAE]-(irm) RETURN irm.nome AS nome, irm.sobrenome AS sobrenome, irm.cpf AS cpf, irm.idade AS idade");

		while (resultadoMae.hasNext()) {

			Record pessoaRelacionadaAtual = resultadoMae.next();

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			pessoaTemporaria.setTipoRelacao("MAE");

			pessoasRelacionadas.add(pessoaTemporaria);

		}

		return pessoasRelacionadas;

	}

	public ArrayList<PessoaRelacionada> burcarEsposa(ArrayList<PessoaRelacionada> pessoasRelacionadas,
			String cpfPrincipal) {

		StatementResult resultadoEsposa = session.run("MATCH (usu {cpf: '" + cpfPrincipal
				+ "'})-[:ESPOSA]-(irm) RETURN irm.nome AS nome, irm.sobrenome AS sobrenome, irm.cpf AS cpf, irm.idade AS idade");

		while (resultadoEsposa.hasNext()) {

			Record pessoaRelacionadaAtual = resultadoEsposa.next();

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			pessoaTemporaria.setTipoRelacao("ESPOSA");

			pessoasRelacionadas.add(pessoaTemporaria);

		}

		return pessoasRelacionadas;

	}

	public ArrayList<PessoaRelacionada> buscarFilhos(ArrayList<PessoaRelacionada> pessoasRelacionadas,
			String cpfPrincipal) {

		StatementResult resultadoFilho = session.run("MATCH (usu {cpf: '" + cpfPrincipal
				+ "'})-[:FILHO]-(irm) RETURN irm.nome AS nome, irm.sobrenome AS sobrenome, irm.cpf AS cpf, irm.idade AS idade");

		while (resultadoFilho.hasNext()) {

			Record pessoaRelacionadaAtual = resultadoFilho.next();

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			pessoaTemporaria.setTipoRelacao("FILHO");

			pessoasRelacionadas.add(pessoaTemporaria);

		}

		return pessoasRelacionadas;

	}

	public ArrayList<PessoaRelacionada> buscarIrmaos(ArrayList<PessoaRelacionada> pessoasRelacionadas,
			String cpfPrincipal) {

		StatementResult resultadoIrmao = session.run("MATCH (usu {cpf: '" + cpfPrincipal
				+ "'})-[:IRMAO]-(irm) RETURN irm.nome AS nome, irm.sobrenome AS sobrenome, irm.cpf AS cpf, irm.idade AS idade");

		while (resultadoIrmao.hasNext()) {

			Record pessoaRelacionadaAtual = resultadoIrmao.next();

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			pessoaTemporaria.setTipoRelacao("IRMAO");

			pessoasRelacionadas.add(pessoaTemporaria);

		}

		return pessoasRelacionadas;

	}

	public ArrayList<PessoaRelacionada> buscarNamorad(ArrayList<PessoaRelacionada> pessoasRelacionadas,
			String cpfPrincipal) {

		StatementResult resultadoNamorada = session.run("MATCH (usu {cpf: '" + cpfPrincipal
				+ "'})-[:NAMORAD]-(irm) RETURN irm.nome AS nome, irm.sobrenome AS sobrenome, irm.cpf AS cpf, irm.idade AS idade");

		while (resultadoNamorada.hasNext()) {

			Record pessoaRelacionadaAtual = resultadoNamorada.next();

			PessoaRelacionada pessoaTemporaria = new PessoaRelacionada();

			pessoaTemporaria.setNome(pessoaRelacionadaAtual.get("nome").asString());
			pessoaTemporaria.setSobrenome(pessoaRelacionadaAtual.get("sobrenome").asString());
			pessoaTemporaria.setCpf(pessoaRelacionadaAtual.get("cpf").asString());
			pessoaTemporaria.setIdade(Integer.parseInt(pessoaRelacionadaAtual.get("idade").asString()));
			pessoaTemporaria.setTipoRelacao("NAMORAD");

			pessoasRelacionadas.add(pessoaTemporaria);

		}

		return pessoasRelacionadas;

	}
	
	public ArrayList<PessoaRelacionada> buscarRelacoes(String cpfPrincipal) {
		
		ArrayList<PessoaRelacionada> pessoasRelacionadas = new ArrayList<PessoaRelacionada>();
		
		pessoasRelacionadas = buscarPai(pessoasRelacionadas, cpfPrincipal);
		pessoasRelacionadas = buscarMarido(pessoasRelacionadas, cpfPrincipal);
		pessoasRelacionadas = buscarMae(pessoasRelacionadas, cpfPrincipal);
		pessoasRelacionadas = burcarEsposa(pessoasRelacionadas, cpfPrincipal);
		pessoasRelacionadas = buscarFilhos(pessoasRelacionadas, cpfPrincipal);
		pessoasRelacionadas = buscarIrmaos(pessoasRelacionadas, cpfPrincipal);
		pessoasRelacionadas = buscarNamorad(pessoasRelacionadas, cpfPrincipal);
		
		session.close();
		
		return pessoasRelacionadas;
		
	}

}