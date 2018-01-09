package fr.tp_clinique.ihm.agenda;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JP_ListRDV extends JPanel{

		public JP_ListRDV(){
			
			String[] entete = {"Heure", "Nom du client", "Animal", "Race"};
			String[][] data = {};
			
			JTable JT_rdv = new JTable(data, entete);
			
			JScrollPane JCP_pane = new JScrollPane(JT_rdv);
			
			add(JCP_pane);
		}
}
