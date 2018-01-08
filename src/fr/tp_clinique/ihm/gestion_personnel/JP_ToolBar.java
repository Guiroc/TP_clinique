package fr.tp_clinique.ihm.gestion_personnel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JP_ToolBar extends JPanel {
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JP_ToolBar() {
		
		this.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5, 5, 5, 5);
		
		JButton JB_add = new JButton("Ajouter");
		JB_add.setPreferredSize(new Dimension(75,25));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(JB_add, gbc);
		
		JButton JB_delete = new JButton("Supprimer");
		JB_delete.setPreferredSize(new Dimension(75,25));
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(JB_delete, gbc);
		
		JButton JB_re = new JButton("Réinitialiser");
		JB_re.setPreferredSize(new Dimension(75,25));
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		add(JB_re, gbc);
	
		setBorder(BorderFactory.createLineBorder(Color.black, 1));		
		
	}

}
