package fr.tp_clinique.ihm.gestion_personnel;

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

	private JLabel JL_nom,
		JL_role,
		JL_mdp;
	
	private JTextField JTF_nom,
		JTF_mdp;
	
	private JComboBox<String> JCB_role;
	
	private JButton JB_annuler,
		JB_valider;
	
	public JF_Ajout_Personnels(){
		
		Dimension colonneGauche = new Dimension(100, 27);
		Dimension colonneDroite = new Dimension(200, 27);

		JL_nom = new JLabel("Nom :");
		JL_nom.setPreferredSize(colonneGauche);
		
		JTF_nom = new JTextField();
		JTF_nom.setPreferredSize(colonneDroite);
		
		JL_role = new JLabel("R�le :");
		JL_role.setPreferredSize(colonneGauche);
		
		JCB_role = new JComboBox<String>();
		JCB_role.setPreferredSize(colonneDroite);
		JCB_role.addItem("adm");
		JCB_role.addItem("vet");
		JCB_role.addItem("sec");
		
		JL_mdp = new JLabel("Mot de passe :");
		JL_mdp.setPreferredSize(colonneGauche);
		
		JTF_mdp = new JTextField();
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
				controleur.enregistrerPersonnnel(new Personnels(JTF_nom.getText().trim(), JCB_role.getItemAt(JCB_role.getSelectedIndex()), JTF_mdp.getText().trim()));
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
		
		add(JP_panel);
		
		this.setSize(400, 300);
		this.setTitle("Employ�s");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
