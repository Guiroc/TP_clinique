package fr.tp_clinique.ihm.gestion_personnel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.tp_clinique.bll.Manager;
import fr.tp_clinique.bll.TableListPersonnels;
import fr.tp_clinique.bo.Personnels;

public class JP_ListUser extends JPanel {

	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();
	JTable JT_listPersonnels;
	ArrayList<Personnels> desPersonnels;
	JScrollPane JSP_pane;
	TableListPersonnels TLP_modele;
	
	public JP_ListUser() {
		
		/*this.setLayout(new GridBagLayout());
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
		add(JP_Password, gbc);*/
		Manager controler = Manager.getInstance();
		
		desPersonnels = controler.getNotArchivePersonnels();
		TLP_modele = new TableListPersonnels(desPersonnels);
		JT_listPersonnels = new JTable(TLP_modele);
		
		
		JSP_pane = new JScrollPane(JT_listPersonnels);
		JSP_pane.setPreferredSize(new Dimension(750, 500));
		
		add(JSP_pane);
		
		setBorder(BorderFactory.createLineBorder(Color.black, 1));	
		
	}
	
	public Personnels getSelectedItem_JT_listPersonnels(){
		
		if(JT_listPersonnels.getSelectedRow() != -1){
			return desPersonnels.get(JT_listPersonnels.getSelectedRow());
		}
		return null;
	}
	
	public void updateJTable(){
		Manager controler = Manager.getInstance();
		desPersonnels = controler.getNotArchivePersonnels();
		TLP_modele.update(desPersonnels);
		TLP_modele.fireTableDataChanged();
	}

}
