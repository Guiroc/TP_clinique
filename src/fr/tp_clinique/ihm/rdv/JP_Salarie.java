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

public class JP_Salarie extends JPanel {
	
	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JP_Salarie() {
		
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(250,150));
		gbc.insets = new Insets(5, 5, 5, 5);
		
		// Vétérinaires		
		JLabel JL_veterinaire = new JLabel("Vétérinaires");
		JL_veterinaire.setPreferredSize(new Dimension(75,25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(JL_veterinaire, gbc);
		
		// ListBox Vétérinaires
		String[] listVet = { "V1", "V2", "V3", "V4", "V5" };
		JComboBox JC_listVet = new JComboBox(listVet);
		JC_listVet.setPreferredSize(new Dimension(150,25));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(JC_listVet, gbc);
		

		
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));	
	}

}
