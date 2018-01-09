package fr.tp_clinique.ihm.connexion;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;


public class JF_Connexion extends JFrame{

	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JF_Connexion(){
		
		add(new JP_Login());
		
		this.setSize(500, 250);
		this.setTitle("Clinique - Connexion");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
