package fr.tp_clinique.ihm.ecran_animaux;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JP_FormulaireAnimaux extends JPanel{

	private static final long serialVersionUID = 1L;

	JLabel JL_code,
		JL_nom,
		JL_couleur,
		JL_espece,
		JL_race,
		JL_tatouage;
	
	JTextField JTF_code,
		JTF_nom,
		JTF_couleur,
		JTF_tatouage;
	
	JComboBox<String> JCB_sexe,
		JCB_espece,
		JCB_race;
	
	JButton JB_valider,
		JB_annuler;
	
	
	
	public JP_FormulaireAnimaux(){
		
		Dimension D_colonneGauche = new Dimension(100, 27);
		Dimension D_colonneCentre = new Dimension(250, 27);
		Dimension D_colonneDroite = new Dimension(100, 27);
		
		JL_code = new JLabel("Code");
		JL_code.setPreferredSize(D_colonneGauche);
		
		JTF_code = new JTextField();
		JTF_code.setPreferredSize(D_colonneCentre);
		
		JL_nom = new JLabel("Nom");
		JL_nom.setPreferredSize(D_colonneDroite);
		
		JTF_nom = new JTextField();
		JTF_nom.setPreferredSize(D_colonneCentre);
		
		JCB_sexe = new JComboBox<String>();
		JCB_sexe.setPreferredSize(D_colonneGauche);
		
		JL_couleur = new JLabel("Couleur");
		JL_couleur.setPreferredSize(D_colonneGauche);
		
		JTF_couleur = new JTextField();
		JTF_couleur.setPreferredSize(D_colonneCentre);
		
		JL_espece = new JLabel("Espèce");
		JL_espece.setPreferredSize(D_colonneGauche);
		
		JCB_espece = new JComboBox<String>();
		JCB_espece.setPreferredSize(D_colonneDroite);
		
		JL_race = new JLabel("Race");
		JL_race.setPreferredSize(D_colonneGauche);
		
		JCB_race = new JComboBox<String>();
		JCB_race.setPreferredSize(D_colonneDroite);
		
		JPanel JP_especeRace = new JPanel();
		JP_especeRace.add(JL_espece);
		JP_especeRace.add(JCB_espece);
		JP_especeRace.add(JL_race);
		JP_especeRace.add(JCB_race);
		
		JL_tatouage = new JLabel("Tatouage");
		JL_tatouage.setPreferredSize(D_colonneGauche);
		
		JTF_tatouage = new JTextField();
		JTF_tatouage.setPreferredSize(D_colonneCentre);
		
		JB_valider = new JButton("Valider");
		
		JB_annuler = new JButton("Annuler");
		
		JPanel JP_button = new JPanel();
		JP_button.add(JB_valider);
		JP_button.add(JB_annuler);
		
		setLayout(new GridBagLayout());
		GridBagConstraints GBC = new GridBagConstraints();
		
		GBC.gridx = 0;
		GBC.gridy = 0;
		add(JL_code, GBC);
		GBC.gridx = 1;
		add(JTF_code, GBC);
		GBC.gridx = 0;
		GBC.gridy = 1;
		add(JL_nom, GBC);
		GBC.gridx = 1;
		add(JTF_nom, GBC);
		GBC.gridx = 2;
		add(JCB_sexe, GBC);
		GBC.gridx = 0;
		GBC.gridy = 2;
		add(JL_couleur, GBC);
		GBC.gridx = 1;
		add(JTF_couleur, GBC);
		GBC.gridx = 0;
		GBC.gridy = 3;
		GBC.gridwidth = 3;
		add(JP_especeRace, GBC);
		GBC.gridx = 0;
		GBC.gridy = 4;
		GBC.gridwidth = 1;
		add(JL_tatouage, GBC);
		GBC.gridx = 1;
		add(JTF_tatouage, GBC);
		GBC.gridx = 0;
		GBC.gridy = 5;
		GBC.gridwidth = 3;
		GBC.anchor = GridBagConstraints.CENTER;
		add(JP_button, GBC);
		
	}
}
