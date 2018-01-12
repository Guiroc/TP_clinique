package fr.tp_clinique.ihm.ecran_client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JF_Ecran_Client extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel JP_panel;
	public JP_Client client = new JP_Client();
	public JP_Animaux animal = new JP_Animaux();
	
	public JF_Ecran_Client(){
		
		JP_panel = new JPanel();
		JP_panel.add(new JP_ToolBar());
		JP_panel.add(client);
		JP_panel.add(animal);
		
		add(JP_panel);
		
		setTitle("Client");
		setSize(new Dimension(1000, 700));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
