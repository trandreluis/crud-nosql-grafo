package br.edu.ifpb.monteiro.ads.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {
	
	private JButton botaoCadastrar;
	private JButton botaoEditar;
	private JButton botaoRemover;
	private JButton visualizarFamilia;
	
	public Inicio() {

		this.setTitle("Cadastro de Famíliares");
		this.setSize(680, 460);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 664, 421);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		visualizarFamilia = new JButton("Visualizar Família");
		visualizarFamilia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		visualizarFamilia.setBounds(10, 376, 138, 34);
		panel.add(visualizarFamilia);
		
		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(367, 376, 89, 34);
		panel.add(botaoCadastrar);
		
		botaoEditar = new JButton("Editar");
		botaoEditar.setBounds(466, 376, 89, 34);
		panel.add(botaoEditar);
		
		botaoRemover = new JButton("Remover");
		botaoRemover.setBounds(565, 376, 89, 34);
		panel.add(botaoRemover);
		
	}
	
	public JButton getBotaoCadastro() {
		return this.botaoCadastrar;
	}
	
	public JButton getBotaoEditar() {
		return this.botaoEditar;
	}
	
	public JButton getBotaoRemover() {
		return this.botaoRemover;
	}
	
}
