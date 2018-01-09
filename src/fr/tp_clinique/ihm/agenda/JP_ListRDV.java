package fr.tp_clinique.ihm.agenda;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JP_ListRDV extends JPanel{

		public JP_ListRDV(){
			
			String[] entete = {"Heure", "Nom du client", "Animal", "Race"};
			String[][] data = {};
			
			JTable JT_rdv = new JTable(data, entete);
			
			JScrollPane JCP_pane = new JScrollPane(JT_rdv);
			JCP_pane.setPreferredSize(new Dimension(800, 500));
			
			add(JCP_pane);
		}
}
