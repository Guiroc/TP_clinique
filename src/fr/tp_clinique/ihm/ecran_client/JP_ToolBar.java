package fr.tp_clinique.ihm.ecran_client;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JP_ToolBar extends JPanel{

	private static final long serialVersionUID = 1L;
	JButton JB_premier;
	JButton JB_precedent;
	JButton JB_suivant;
	JButton JB_dernier;
	JButton JB_rechercher;
	JButton JB_ajouter;
	JButton JB_supprimer;
	
	JLabel JL_espace1;
	JLabel JL_espace2;
	
	JTextField JTF_rechercher;	
	
	public JP_ToolBar(){
		
		JB_premier = new JButton("Premier");
		JB_precedent = new JButton("Précedent");
		JB_suivant = new JButton("Suivant");
		JB_dernier = new JButton("Dernier");
		
		JL_espace1 = new JLabel("");
		JL_espace1.setPreferredSize(new Dimension(100,0));
		
		JB_ajouter = new JButton("Ajouter");
		JB_supprimer = new JButton("Supprimer");
		
		JL_espace2 = new JLabel("");
		JL_espace2.setPreferredSize(new Dimension(100,0));
		
		JTF_rechercher = new JTextField();
		JTF_rechercher.setPreferredSize(new Dimension(120, 27));
		JB_rechercher = new JButton("Rechercher");
		
		add(JB_premier);
		add(JB_precedent);
		add(JB_suivant);
		add(JB_dernier);
		add(JL_espace1);
		add(JB_ajouter);
		add(JB_supprimer);
		add(JL_espace2);
		add(JTF_rechercher);
		add(JB_rechercher);
		
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}
}
