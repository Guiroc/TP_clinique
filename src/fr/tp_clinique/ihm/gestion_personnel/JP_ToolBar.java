package fr.tp_clinique.ihm.gestion_personnel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.tp_clinique.bll.Manager;

public class JP_ToolBar extends JPanel {
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JP_ToolBar() {
		
		this.setLayout(new GridBagLayout());
		gbc.insets = new Insets(20, 20, 20, 20);
		
		JButton JB_add = new JButton("Ajouter");
		JB_add.setPreferredSize(new Dimension(100,30));
		JB_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Manager controler = Manager.getInstance();
				controler.ouvrirJP_Ajout_Personnels();			}
		});
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(JB_add, gbc);
		
		JButton JB_delete = new JButton("Supprimer");
		JB_delete.setPreferredSize(new Dimension(100,30));
		JB_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Manager controler = Manager.getInstance();
				controler.deletePersonnelsById();
			}
		});
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		add(JB_delete, gbc);
		
		JButton JB_re = new JButton("Réinitialiser");
		JB_re.setPreferredSize(new Dimension(150,30));
		JB_re.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Manager controler = Manager.getInstance();
				controler.ouvrirJP_Modifer_MDP();
			}
		});
		
		gbc.gridx = 6;
		gbc.gridy = 0;
		add(JB_re, gbc);
		
		// C'est sale !		
		JLabel JL_space = new JLabel("");
		JL_space.setPreferredSize(new Dimension(345,25));
		
		gbc.gridx = 8;
		gbc.gridy = 0;
		add(JL_space, gbc);
	
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));	
//		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
		
	}

}
