package fr.tp_clinique.ihm.rdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JP_Client extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JP_Client() {
		
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(250,150));
		gbc.insets = new Insets(5, 5, 5, 5);
		
		// Clients		
		JLabel JL_client = new JLabel("Clients");
		JL_client.setPreferredSize(new Dimension(50,25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(JL_client, gbc);
		
		// ListBox Clients
		String[] listClients = { "C1", "C2", "C3", "C4", "C5" };
		JComboBox JC_listClient = new JComboBox(listClients);
		JC_listClient.setPreferredSize(new Dimension(150,25));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(JC_listClient, gbc);
		
		// Animaux		
		JLabel JL_animaux = new JLabel("Animal");
		JL_animaux.setPreferredSize(new Dimension(50,25));
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(JL_animaux, gbc);
		
		// ListBox Animaux
		String[] listAnimaux = { "A1", "A2", "A3", "A4", "A5" };
		JComboBox JC_listAnimaux = new JComboBox(listAnimaux);
		JC_listAnimaux.setPreferredSize(new Dimension(150,25));
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(JC_listAnimaux, gbc);
		
		
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));	
	}
	
}
