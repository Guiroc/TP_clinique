import javax.swing.SwingUtilities;

import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.ClientDAO;
import fr.tp_clinique.dal.DALException;
import fr.tp_clinique.ihm.rdv.JF_RDV;


public class AppliRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				
				Clients c = new Clients(1, "a", "b", "c", "d", "e", "f", "g", "h", "i", "f");
				ClientDAO insertClient = new ClientDAO();
				try {
					insertClient.insert(c);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		//new JF_Connexion();
		//new JF_Ecran_Animaux();
		//new JF_Gestion_Personnel();
		//new JF_Agenda();
		//new JF_Ecran_Client();
		//new JF_Ecran_Animaux();
		new JF_RDV();
	}

}
