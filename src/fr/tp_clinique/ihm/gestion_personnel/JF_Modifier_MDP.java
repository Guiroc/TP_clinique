package fr.tp_clinique.ihm.gestion_personnel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.tp_clinique.bll.Manager;

public class JF_Modifier_MDP extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel JL_mdp;
	private JTextField JTF_mdp;
	private JButton JB_valider;
	private JPanel JP_panel;
	
	public JF_Modifier_MDP(){
		
		JL_mdp = new JLabel("Mot de Passe");
		
		JTF_mdp = new JTextField();
		JTF_mdp.setPreferredSize(new Dimension(150, 27));
		
		JB_valider = new JButton("Valider");
		JB_valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Manager controleur = Manager.getInstance();
				controleur.modifierMdp(JTF_mdp.getText().trim());		
			}
		});
		
		JP_panel = new JPanel();
		
		JP_panel.add(JL_mdp);
		JP_panel.add(JTF_mdp);
		JP_panel.add(JB_valider);
		
		this.add(JP_panel);
		this.setSize(200, 200);
		this.setTitle("Mot de Passe utilisateur");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
