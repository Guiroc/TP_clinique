import javax.swing.SwingUtilities;
import fr.tp_clinique.ihm.ecran_client.JF_Ecran_Client;
import fr.tp_clinique.ihm.ecran_animaux.JF_Ecran_Animaux;
import fr.tp_clinique.ihm.rdv.JF_RDV;



import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.ClientDAO;
import fr.tp_clinique.dal.DALException;
import fr.tp_clinique.ihm.connexion.JF_Connexion;
import fr.tp_clinique.ihm.connexion.JP_Login;
import fr.tp_clinique.ihm.gestion_personnel.JF_Gestion_Personnel;
import fr.tp_clinique.ihm.rdv.JF_Rdv;


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
		
		
		
		
		new JF_Ecran_Client();
		//new JF_Ecran_Animaux();
		new JF_RDV();
	}

}
