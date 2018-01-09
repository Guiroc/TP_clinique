package fr.tp_clinique.ihm.connexion;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JP_Login extends JPanel {
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	
	public JP_Login() {
		
		this.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5, 5, 5, 5);
		
		JLabel JL_name = new JLabel("Nom");
		JL_name.setPreferredSize(new Dimension(100,25));
		JLabel JL_mdp = new JLabel("Mot de passe");
		JL_mdp.setPreferredSize(new Dimension(100,25));
		
		JTextField JT_input = new JTextField(15);
		JT_input.setPreferredSize(new Dimension(25,25));
		
		JPasswordField JP_user = new JPasswordField(15);
		JP_user.setPreferredSize(new Dimension(25,25));
		
		JButton JB_button = new JButton("Valider");
		JB_button.setPreferredSize(new Dimension(75,25));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(JL_name, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		add(JT_input, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(JL_mdp, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 1;
		add(JP_user, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(JB_button, gbc);
	}
	
}
