import javax.swing.SwingUtilities;

import fr.tp_clinique.ihm.connexion.JF_Connexion;
import fr.tp_clinique.ihm.connexion.JP_Login;
import fr.tp_clinique.ihm.gestion_personnel.JF_Gestion_Personnel;


public class AppliRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				
				JF_Gestion_Personnel connexion = new JF_Gestion_Personnel();

			}
		});
		
		
		
		
	}

}
