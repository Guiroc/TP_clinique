package fr.tp_clinique.ihm.rdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import org.jdatepicker.JDatePicker;

public class JP_Date extends JPanel {
	
	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public JP_Date() {
		
		this.setPreferredSize(new Dimension(250,150));
		gbc.insets = new Insets(5, 5, 5, 5);
		
		// Date		
		JLabel JL_date = new JLabel("Date");
		JL_date.setPreferredSize(new Dimension(150,25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(JL_date, gbc);
		
		// JDatePicker date
		JDatePicker JD_date = new JDatePicker();
		JD_date.setPreferredSize(new Dimension(150,25));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(JD_date, gbc);
		
		//Heure
		JLabel JL_heure = new JLabel("Heure");
		JL_heure.setPreferredSize(new Dimension(150,25));
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(JL_heure, gbc);
		
		//JComboBox heure
		String[] heure = { "1", "2", "3", "4", "5" };
		JComboBox JC_heure = new JComboBox(heure);
		JC_heure.setPreferredSize(new Dimension(100,25));
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(JC_heure, gbc);
		
		// Text heure	
		JLabel JL_heureText = new JLabel("h");
		JL_heureText.setPreferredSize(new Dimension(25,25));
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(JL_heureText, gbc);
		
		//JComboBox heure
		String[] minute = { "1", "2", "3", "4", "5" };
		JComboBox JC_minute = new JComboBox(minute);
		JC_minute.setPreferredSize(new Dimension(100,25));
		gbc.gridx = 4;
		gbc.gridy = 4;
		add(JC_minute, gbc);
		
		
		

		
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));	
	}
}
