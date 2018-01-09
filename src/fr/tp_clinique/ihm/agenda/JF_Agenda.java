package fr.tp_clinique.ihm.agenda;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JF_Agenda extends JFrame{

	private static final long serialVersionUID = 1L;

	public JF_Agenda(){
		
		JPanel JP_panel = new JPanel();
		
		JP_panel.add(new JP_ToolBar());
		JP_panel.add(new JP_ListRDV());
		
		add(JP_panel);
		
		setTitle("Agenda");
		setSize(new Dimension(1000, 700));
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
