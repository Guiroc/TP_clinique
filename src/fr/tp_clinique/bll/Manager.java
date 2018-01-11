package fr.tp_clinique.bll;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.bo.Personnels;
import fr.tp_clinique.dal.ClientDAO;
import fr.tp_clinique.dal.DALException;
import fr.tp_clinique.dal.DAOFactory;
import fr.tp_clinique.dal.PersonnelsDAO;
import fr.tp_clinique.dal.jdbc.JdbcTools;
import fr.tp_clinique.ihm.agenda.JF_Agenda;
import fr.tp_clinique.ihm.ajout_personnels.JF_Ajout_Personnels;
import fr.tp_clinique.ihm.connexion.JF_Connexion;
import fr.tp_clinique.ihm.ecran_client.JF_Ecran_Client;
import fr.tp_clinique.ihm.gestion_personnel.JF_Gestion_Personnel;

public class Manager {
	
	private static Manager instance = null;
	
	private ClientDAO clientDAO;
	private PersonnelsDAO personnelsDAO;
	
	private JF_Connexion fenetreConnexion;
	private JF_Gestion_Personnel fenetreGestionPersonnels;
	
	private static Personnels unePersonne;
	JF_Ecran_Client fenetreAddClient;

		private Manager(){
			unePersonne = null;
			personnelsDAO = DAOFactory.getPersonnelsDAO();
			clientDAO = DAOFactory.getClientDAO();
			try {
				JdbcTools.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			run();
		}
		
		public static synchronized Manager getInstance(){

			if (instance == null){
				instance = new Manager();	
			}
			return instance;
		}
		
		public void run(){
			fenetreConnexion = new JF_Connexion();
		}
		
		public void Connexion(String login, char[] motDePasse){
			String mdp = "";
			for(int i = 0; i < motDePasse.length; i++){
				mdp += motDePasse[i];
			}
			
			Personnels unePersonne = personnelsDAO.getUnPersonnel(login, mdp);
			
			if(unePersonne != null){
					
				Manager.unePersonne = unePersonne;
				switch (unePersonne.getRole()){
				
				//admin
				case "adm":
					fenetreConnexion.dispose();
					fenetreGestionPersonnels = new JF_Gestion_Personnel();
					break;
				//veterinaire
				case "vet":
					fenetreConnexion.dispose();
					fenetreAddClient = new JF_Ecran_Client();
					break;
				//secrétaire
				case "sec":
					fenetreConnexion.dispose();
					new JF_Agenda();
					break;
				default:
					
					break;
				}
			}
			else{
				
			}
		}

		public ArrayList<Personnels> getNotArchivePersonnels() {
			// TODO Auto-generated method stub
			return personnelsDAO.getNotArchivePersonnels();
		}

		
		
		public void addClient() {
			
			try {
				clientDAO.insert(fenetreAddClient.client.getInputClient());
				
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		public void deletePersonnelsById() {
			// TODO Auto-generated method stub
			personnelsDAO.DeletePersonnelsById(fenetreGestionPersonnels.getSelectedItem_JT_listPersonnels().getCodePers());
		}

		public void ajouterPersonnels() {
			// TODO Auto-generated method stub
			new JF_Ajout_Personnels();
		}

		public void enregistrerPersonnnel(Personnels personnels) {
			// TODO Auto-generated method stub
			personnelsDAO.addPersonnel(personnels);

			
		}
}
