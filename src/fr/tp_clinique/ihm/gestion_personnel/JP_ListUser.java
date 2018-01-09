package fr.tp_clinique.ihm.gestion_personnel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class JP_ListUser extends JPanel {
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JP_ListUser() {
		
		this.setLayout(new GridBagLayout());
		gbc.insets = new Insets(20, 20, 20, 20);
		
		
		// Nom de l'utilisateur		
		JLabel JL_nom = new JLabel("Nom");
		JL_nom.setPreferredSize(new Dimension(50,25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(JL_nom, gbc);
		
		// Prénom de l'utilisateur	
		JLabel JL_prenom = new JLabel("Prénom");
		JL_prenom.setPreferredSize(new Dimension(350,25));
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(JL_prenom, gbc);
		
		// Métier de l'utilisateur	
		JLabel JL_metier = new JLabel("Métier");
		JL_metier.setPreferredSize(new Dimension(75,25));
		gbc.gridx = 4;
		gbc.gridy = 0;
		add(JL_metier, gbc);
		
		// Password de l'utilisateur		
		JPasswordField JP_Password = new JPasswordField(15);
		JP_Password.setPreferredSize(new Dimension(25,25));
		gbc.gridx = 6;
		gbc.gridy = 0;
		add(JP_Password, gbc);
		
		setBorder(BorderFactory.createLineBorder(Color.black, 1));	
		
	}

}
