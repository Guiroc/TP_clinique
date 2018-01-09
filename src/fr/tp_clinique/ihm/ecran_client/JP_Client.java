package fr.tp_clinique.ihm.ecran_client;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JP_Client extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel JL_code,
		JL_nom,
		JL_prenom,
		JL_adresse,
		JL_cp,
		JL_ville;
	
	JTextField JTF_code,
		JTF_nom,
		JTF_prenom,
		JTF_adresse1,
		JTF_adresse2,
		JTF_cp,
		JTF_ville;
	
	public JP_Client(){
		
		Dimension D_colonneGauche = new Dimension(100, 27);
		Dimension D_colonneDroite = new Dimension(300, 27);
		
		JL_code = new JLabel("Code");
		JL_code.setPreferredSize(D_colonneGauche);
		
		JTF_code = new JTextField();
		JTF_code.setPreferredSize(D_colonneDroite);
		
		JL_nom = new JLabel("Nom");
		JL_nom.setPreferredSize(D_colonneGauche);
		
		JTF_nom = new JTextField();
		JTF_nom.setPreferredSize(D_colonneDroite);
		
		JL_prenom = new JLabel("Prénom");
		JL_prenom.setPreferredSize(D_colonneGauche);
		
		JTF_prenom = new JTextField();
		JTF_prenom.setPreferredSize(D_colonneDroite);
		
		JL_adresse = new JLabel("Adresse");
		JL_adresse.setPreferredSize(D_colonneGauche);
		
		JTF_adresse1 = new JTextField();
		JTF_adresse1.setPreferredSize(D_colonneDroite);
		
		JTF_adresse2 = new JTextField();
		JTF_adresse2.setPreferredSize(D_colonneDroite);
		
		JL_cp = new JLabel("Code postal");
		JL_cp.setPreferredSize(D_colonneGauche);
		
		JTF_cp = new JTextField();
		JTF_cp.setPreferredSize(D_colonneDroite);
		
		JL_ville = new JLabel("Ville");
		JL_ville.setPreferredSize(D_colonneGauche);
		
		JTF_ville = new JTextField();
		JTF_ville.setPreferredSize(D_colonneDroite);
		
		setLayout(new GridBagLayout());
		GridBagConstraints GBC_grille = new GridBagConstraints();
		
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 0;
		add(JL_code, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_code, GBC_grille);
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 1;
		add(JL_nom, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_nom, GBC_grille);
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 2;
		add(JL_prenom, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_prenom, GBC_grille);
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 3;
		add(JL_adresse, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_adresse1, GBC_grille);
		GBC_grille.gridx = 1;
		GBC_grille.gridy = 4;
		add(JTF_adresse2, GBC_grille);
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 5;
		add(JL_cp, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_cp, GBC_grille);
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 6;
		add(JL_ville, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_ville, GBC_grille);
			
	}
}
