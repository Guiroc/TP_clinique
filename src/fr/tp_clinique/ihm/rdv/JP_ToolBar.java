package fr.tp_clinique.ihm.rdv;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import fr.tp_clinique.bo.Personnels;

public class JP_ToolBar extends JPanel{

	JLabel JL_veterinaire,
		JL_date;
	
	JComboBox<Personnels> JCB_veterinaire;
	
	JDatePicker JDP_date;
	
	public JP_ToolBar(){
		
		JL_veterinaire = new JLabel("Vétérinaire");
		
		JCB_veterinaire = new JComboBox<Personnels>();
		
		JL_date = new JLabel("Date");
		
		JDP_date = new JDatePicker();
		
		add(JL_veterinaire);
		add(JCB_veterinaire);
		add(JL_date);
		add(JDP_date);
		
		setBorder(BorderFactory.createTitledBorder("De :" ));
	}
}
