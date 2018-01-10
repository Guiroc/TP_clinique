import javax.swing.SwingUtilities;

import fr.tp_clinique.bo.Animaux;
import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.AnimauxDAO;
import fr.tp_clinique.dal.ClientDAO;
import fr.tp_clinique.dal.DALException;
import fr.tp_clinique.ihm.rdv.JF_RDV;


public class AppliRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				

			
			
				AnimauxDAO insertAnimal = new AnimauxDAO();
				
				try {
					Animaux animal = insertAnimal.selectById(3);
					animal.setCouleur("NOIRRR");
					insertAnimal.update(animal);
					insertAnimal.selectAll();
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		});
		
	}

}
