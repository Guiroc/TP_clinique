package fr.tp_clinique.ihm.ecran_animaux;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.sun.security.ntlm.Client;

public class JP_SelectClient extends JPanel{

	private static final long serialVersionUID = 1L;

	JComboBox<Client> JCB_clients;
	
	public JP_SelectClient(){
		
		JCB_clients = new JComboBox<Client>();
		JCB_clients.setPreferredSize(new Dimension(400, 27));
		
		add(JCB_clients);
		
		
		setBorder(BorderFactory.createTitledBorder("Client :" ));
	}
}
