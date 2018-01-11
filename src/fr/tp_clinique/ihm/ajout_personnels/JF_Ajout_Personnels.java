package fr.tp_clinique.ihm.ajout_personnels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.tp_clinique.bll.Manager;
import fr.tp_clinique.bo.Personnels;

public class JF_Ajout_Personnels extends JFrame{

	private static final long serialVersionUID = 1L;

	JLabel JL_nom;
	JTextField JTF_nom;
	JLabel JL_role;
	JComboBox<String> JCB_role;
	JLabel JL_mdp;
	JTextField JTF_mdp;
	JButton JB_annuler;
	JButton JB_valider;
	
	public JF_Ajout_Personnels(){
		
		Dimension colonneGauche = new Dimension(100, 27);
		Dimension colonneDroite = new Dimension(200, 27);

		JL_nom = new JLabel("Nom :");
		JL_nom.setPreferredSize(colonneGauche);
		
		JTF_nom = new JTextField(30);
		JTF_nom.setPreferredSize(colonneDroite);
		
		JL_role = new JLabel("Rôle :");
		JL_role.setPreferredSize(colonneGauche);
		
		JCB_role = new JComboBox<String>();
		JCB_role.setPreferredSize(colonneDroite);
		JCB_role.addItem("adm");
		JCB_role.addItem("vet");
		JCB_role.addItem("sec");
		
		JL_mdp = new JLabel("Mot de passe :");
		JL_mdp.setPreferredSize(colonneGauche);
		
		JTF_mdp = new JTextField(10);
		JTF_mdp.setPreferredSize(colonneDroite);
		
		JB_annuler = new JButton("Annuler");
		JB_annuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		JB_valider = new JButton("Valider");
		JB_valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Manager controleur = Manager.getInstance();
				System.out.println(JTF_nom.getText());
				System.out.println((String) JCB_role.getItemAt(JCB_role.getSelectedIndex()));
				System.out.println(JTF_mdp.getText());
				controleur.enregistrerPersonnnel(new Personnels(JTF_nom.getText(), JCB_role.getItemAt(JCB_role.getSelectedIndex()), JTF_mdp.getText()));
				dispose();
			}
		});
		
		JPanel JP_panel = new JPanel();
		JP_panel.setLayout(new GridBagLayout());
		
		GridBagConstraints GBC = new GridBagConstraints();
		
		GBC.gridx = 0;
		GBC.gridy = 0;
		JP_panel.add(JL_nom, GBC);
		GBC.gridx = 1;
		JP_panel.add(JTF_nom, GBC);
		GBC.gridx = 0;
		GBC.gridy = 1;
		JP_panel.add(JL_role, GBC);
		GBC.gridx = 1;
		JP_panel.add(JCB_role, GBC);
		GBC.gridx = 0;
		GBC.gridy = 2;
		JP_panel.add(JL_mdp, GBC);
		GBC.gridx = 1;
		JP_panel.add(JTF_mdp, GBC);
		GBC.gridx = 0;
		GBC.gridy = 3;
		JP_panel.add(JB_annuler, GBC);
		GBC.gridx = 1;
		JP_panel.add(JB_valider, GBC);
		
		
		JPanel JP_panel2 = new JPanel();
		JP_panel2.add(JP_panel);
		add(JP_panel2);
		
		this.setSize(500, 500);
		this.setTitle("Employés");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
