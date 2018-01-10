
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingUtilities;

import fr.tp_clinique.bo.Agendas;
import fr.tp_clinique.bo.Animaux;
import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.AgendaDAO;
import fr.tp_clinique.dal.AnimauxDAO;
import fr.tp_clinique.dal.ClientDAO;
import fr.tp_clinique.dal.DALException;
import fr.tp_clinique.ihm.rdv.JF_RDV;


public class AppliRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				
			
				AgendaDAO insertRdv = new AgendaDAO();
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				Agendas agenda = new Agendas(7,date,3);
				
				try {
					insertRdv.delete(agenda);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		});
		
	}

}
