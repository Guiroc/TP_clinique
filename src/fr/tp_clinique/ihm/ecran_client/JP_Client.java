package fr.tp_clinique.ihm.ecran_client;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.ClientDAO;
import fr.tp_clinique.dal.DALException;

public class JP_Client extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel JL_code,
		JL_nom,
		JL_prenom,
		JL_adresse,
		JL_cp,
		JL_ville,
		JL_numTel,
		JL_assurance,
		JL_email,
		JL_remarque;
	
	JTextField JTF_code,
		JTF_nom,
		JTF_prenom,
		JTF_adresse1,
		JTF_adresse2,
		JTF_cp,
		JTF_ville,
		JTF_numTel,
		JTF_assurance,
		JTF_email,
		JTF_remarque;
	
	public JP_Client(){
		
		Dimension D_colonneGauche = new Dimension(100, 27);
		Dimension D_colonneDroite = new Dimension(300, 27);
		
		
		
	
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
		
		JL_numTel = new JLabel("Numéro");
		JL_numTel.setPreferredSize(D_colonneGauche);
		
		JTF_numTel = new JTextField();
		JTF_numTel.setPreferredSize(D_colonneDroite);
		
		JL_assurance = new JLabel("Assurance");
		JL_assurance.setPreferredSize(D_colonneGauche);
		
		JTF_assurance = new JTextField();
		JTF_assurance.setPreferredSize(D_colonneDroite);
		
		JL_email = new JLabel("Email");
		JL_email.setPreferredSize(D_colonneGauche);
		
		JTF_email = new JTextField();
		JTF_email.setPreferredSize(D_colonneDroite);
		
		JL_remarque = new JLabel("Remarque");
		JL_remarque.setPreferredSize(D_colonneGauche);
		
		JTF_remarque = new JTextField();
		JTF_remarque.setPreferredSize(D_colonneDroite);
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints GBC_grille = new GridBagConstraints();
		
		
		


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
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 7;
		add(JL_numTel, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_numTel, GBC_grille);
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 8;
		add(JL_assurance, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_assurance, GBC_grille);		
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 9;
		add(JL_email, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_email, GBC_grille);
		GBC_grille.gridx = 0;
		GBC_grille.gridy = 10;
		add(JL_remarque, GBC_grille);
		GBC_grille.gridx = 1;
		add(JTF_remarque, GBC_grille);
			
	}
	
	public Clients getInputClient() {
		
		Clients addClient = new Clients(JTF_nom.getText(), JTF_prenom.getText(), JTF_adresse1.getText(), JTF_adresse2.getText(), 
				JTF_cp.getText(), JTF_ville.getText(), JTF_numTel.getText(), JTF_assurance.getText(), JTF_email.getText(), JTF_remarque.getText());
		
		return addClient;
	}
	
	public void displayClient(Clients client) {
		
		JTF_nom.setText(client.getClient());
		JTF_prenom.setText(client.getPrenomClient());
		JTF_adresse1.setText(client.getAdresse1());
		JTF_adresse2.setText(client.getAdresse2());
		JTF_cp.setText(client.getCodePostal());
		JTF_ville.setText(client.getVille());
		JTF_numTel.setText(client.getNumTel());
		JTF_assurance.setText(client.getAssurance());
		JTF_email.setText(client.getEmail());
		JTF_remarque.setText(client.getRemarque());
		
	}
	

	
	
}
