package fr.tp_clinique.ihm.rdv;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JP_ListRDV extends JPanel{

	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JP_ListRDV() {
		
		this.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5, 5, 5, 5);
		
		String[] columnNames = {"Heure ",
                "Nom du client",
                "Animal",
                "Race"};
		
		Object[][] data = {
			    {"10h",
			    "John",
			    "Blabla",
			    "Porg"}
			};
		
		JTable listRdv = new JTable(data, columnNames);
		
		JScrollPane JS_scroll = new JScrollPane(listRdv);
		gbc.gridx = 0;
		gbc.gridy = 0;
		JS_scroll.setPreferredSize(new Dimension(760,350));
		add(JS_scroll, gbc);
		
		JButton JB_delete = new JButton("Supprimer");
		JB_delete.setPreferredSize(new Dimension(100,25));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(JB_delete, gbc);
		
		JButton JB_add = new JButton("Valider");
		JB_add.setPreferredSize(new Dimension(100,25));
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(JB_add, gbc);
	}
}
