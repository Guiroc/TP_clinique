package fr.tp_clinique.ihm.rdv;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.JDatePicker;

import fr.tp_clinique.bo.Personnels;

public class JP_ToolBar extends JPanel{

	private static final long serialVersionUID = 1L;

	JLabel JL_veterinaire,
		JL_date;
	
	JComboBox<Personnels> JCB_veterinaire;
	
	JDatePicker JDP_date;
	
	public JP_ToolBar(){
		
		JL_veterinaire = new JLabel("Vétérinaire");
		
		JCB_veterinaire = new JComboBox<Personnels>();
		JCB_veterinaire.setPreferredSize(new Dimension(200, 27));
		
		JL_date = new JLabel("Date");
		
		JDP_date = new JDatePicker();
		
		add(JL_veterinaire);
		add(JCB_veterinaire);
		add(JL_date);
		add(JDP_date);
		
		setPreferredSize(new Dimension(800, 60));
		setBorder(BorderFactory.createTitledBorder("De :" ));
	}
}
