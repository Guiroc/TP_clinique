package fr.tp_clinique.ihm.ecran_client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.tp_clinique.ihm.ecran_animaux.JF_Ecran_Animaux;

public class JP_Animaux extends JPanel{

	private static final long serialVersionUID = 1L;
	JButton JB_ajouter,
		JB_supprimer,
		JB_editer;
	
	JTable JT_animaux;
	
	public JP_Animaux(){
		
		String[] entetes = {"Numero", "Nom", "Sexe", "Couleur", "Race", "Espèce", "Tatouage"};
		Object[][] donnees = {};
		JT_animaux = new JTable(donnees, entetes);
		
		JScrollPane JSP_listAnimaux = new JScrollPane(JT_animaux);
	
		
		JB_ajouter = new JButton("Ajouter");
		JB_ajouter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new JF_Ecran_Animaux();
			}
		});
		
		JB_supprimer = new JButton("Supprimer");
		
		JB_editer = new JButton("Editer");
		
		JPanel JP_toolBarAnimaux = new JPanel();
		JP_toolBarAnimaux.add(JB_ajouter);
		JP_toolBarAnimaux.add(JB_supprimer);
		JP_toolBarAnimaux.add(JB_editer);
		
		setLayout(new GridBagLayout());
		GridBagConstraints GBC_grille = new GridBagConstraints();
		
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 0;
		add(JSP_listAnimaux, GBC_grille);
		GBC_grille.gridy = 1;
		add(JP_toolBarAnimaux, GBC_grille);
	
	}
}
