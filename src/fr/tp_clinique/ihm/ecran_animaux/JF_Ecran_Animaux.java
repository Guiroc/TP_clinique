package fr.tp_clinique.ihm.ecran_animaux;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JF_Ecran_Animaux extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JPanel JP_panel;
	
	public JF_Ecran_Animaux(){
		
		JP_panel = new JPanel();
		JP_panel.add(new JP_SelectClient());
		JP_panel.add(new JP_FormulaireAnimaux());
		
		add(JP_panel);
		
		setTitle("Animaux");
		setSize(new Dimension(550, 500));
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
