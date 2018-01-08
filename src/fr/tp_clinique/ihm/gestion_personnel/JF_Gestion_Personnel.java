package fr.tp_clinique.ihm.gestion_personnel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.tp_clinique.ihm.connexion.JP_Login;

public class JF_Gestion_Personnel extends JFrame{

	private static final long serialVersionUID = 1L;

	GridBagConstraints gbc = new GridBagConstraints();
	
	public JF_Gestion_Personnel(){
		
		JPanel JP_panel = new JPanel();
		JP_panel.add(new JP_ToolBar());
		
		add(JP_panel);
		
		this.setSize(1000, 700);
		this.setTitle("Employés");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
