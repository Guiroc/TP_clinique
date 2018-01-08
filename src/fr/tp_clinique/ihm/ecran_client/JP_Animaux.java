package fr.tp_clinique.ihm.ecran_client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JP_Animaux extends JPanel{

	private static final long serialVersionUID = 1L;
	JButton JB_ajouter;
	JButton JB_supprimer;
	JButton JB_editer;
	
	JTable JT_animaux;
	
	public JP_Animaux(){
		
		String[] entetes = {"Numero", "Nom", "Sexe", "Couleur", "Race", "Espèce", "Tatouage"};
		Object[][] donnees = {};
		JT_animaux = new JTable(donnees, entetes);
		
		JScrollPane JSP_listAnimaux = new JScrollPane(JT_animaux);
	
		JB_ajouter = new JButton("Ajouter");
		
		JB_supprimer = new JButton("Supprimer");
		
		JB_editer = new JButton("Editer");
		
		setLayout(new GridBagLayout());
		GridBagConstraints GBC_grille = new GridBagConstraints();
		
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 0;
		GBC_grille.gridwidth = 3;
		add(JSP_listAnimaux, GBC_grille);
		GBC_grille.anchor = GridBagConstraints.LINE_END;
		GBC_grille.gridwidth = 1;
		GBC_grille.gridy = 1;
		add(JB_ajouter, GBC_grille);
		GBC_grille.gridx = 1;
		add(JB_supprimer, GBC_grille);
		GBC_grille.gridx = 2;
		add(JB_editer, GBC_grille);
		
		
		
	}
}
