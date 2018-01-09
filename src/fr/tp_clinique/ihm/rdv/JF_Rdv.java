package fr.tp_clinique.ihm.rdv;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class JF_Rdv extends JFrame{
	
	GridBagConstraints gbc = new GridBagConstraints();
	private static final long serialVersionUID = 1L;
	
	public JF_Rdv() {
		
		//Panel content		
		JPanel JP_content = new JPanel();
		
		// Clients
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JP_content.add(new JP_Client(),gbc);
		
		// Vétérinaires
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		JP_content.add(new JP_Salarie(),gbc);
		
		// Dates
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 0;
		
		JP_content.add(new JP_Date(),gbc);
		
		//Liste RDV
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		JP_content.add(new JP_ListRDV(),gbc);
		
		
		add(JP_content);
	
		this.setSize(1000, 700);
		this.setTitle("Prise de rendez-vous");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	

}
