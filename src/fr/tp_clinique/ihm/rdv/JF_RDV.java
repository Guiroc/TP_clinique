
package fr.tp_clinique.ihm.rdv;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JF_RDV extends JFrame{

	private static final long serialVersionUID = 1L;

	public JF_RDV(){
		
		JPanel JP_panel = new JPanel();
		JP_panel.setLayout(new GridBagLayout());
		
		GridBagConstraints GBC = new GridBagConstraints();
		GBC.gridx = 0;
		GBC.gridy = 0;
		JP_panel.add(new JP_ToolBar(), GBC);
		GBC.gridy = 1;
		JP_panel.add(new JP_ListRDV(), GBC);
		
		add(JP_panel);
		
		setTitle("Agenda");
		setSize(new Dimension(1000, 700));
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
