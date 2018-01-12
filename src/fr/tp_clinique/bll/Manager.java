package fr.tp_clinique.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.tp_clinique.bo.Animaux;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.bo.Personnels;
import fr.tp_clinique.dal.AnimauxDAO;
import fr.tp_clinique.dal.ClientDAO;
import fr.tp_clinique.dal.DALException;
import fr.tp_clinique.dal.DAOFactory;
import fr.tp_clinique.dal.PersonnelsDAO;
import fr.tp_clinique.dal.jdbc.JdbcTools;
import fr.tp_clinique.ihm.agenda.JF_Agenda;
import fr.tp_clinique.ihm.connexion.JF_Connexion;
import fr.tp_clinique.ihm.dialog.JD_Information;
import fr.tp_clinique.ihm.ecran_client.JF_Ecran_Client;
import fr.tp_clinique.ihm.gestion_personnel.JF_Ajout_Personnels;
import fr.tp_clinique.ihm.gestion_personnel.JF_Gestion_Personnel;
import fr.tp_clinique.ihm.gestion_personnel.JF_Modifier_MDP;

public class Manager {
	
	private static Manager instance = null;
	
	private ClientDAO clientDAO;
	private PersonnelsDAO personnelsDAO;
	private AnimauxDAO animauxDAO;
	
	private JF_Connexion fenetreConnexion;
	private JF_Gestion_Personnel fenetreGestionPersonnels;

	private int positionClient = 0;
	private List<Clients> listClient;

	private JF_Ecran_Client fenetreAddClient;
	private JF_Ajout_Personnels fenetreAjoutPersonnels;
	private JF_Modifier_MDP fenetreModifierMdp;

	private static Personnels unePersonne;

		private Manager(){
			
			unePersonne = null;
			personnelsDAO = DAOFactory.getPersonnelsDAO();
			clientDAO = DAOFactory.getClientDAO();
			animauxDAO = DAOFactory.getAnimauxDAO();
			
			
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
					try {
						listClient = clientDAO.selectAll();
					} catch (DALException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
				String[] texte = {"Le nom ou le mot de passe est incorrect."};
				new JD_Information(texte);
			}
		}

		public ArrayList<Personnels> getNotArchivePersonnels() {
			// TODO Auto-generated method stub
			return personnelsDAO.getNotArchivePersonnels();
		}

		public void deletePersonnelsById() {
			// TODO Auto-generated method stub
			Personnels personnel = fenetreGestionPersonnels.getSelectedItem_JT_listPersonnels();
			if(personnel == null){
				String[] texte = {"Veuillez selectionner un utilisateur."};
				new JD_Information(texte);
			}
			else{
				int rs = personnelsDAO.DeletePersonnelsById(personnel.getCodePers());
				
				if(rs > 0){
					String[] texte = {"L'utilisateur a été supprimer."};
					new JD_Information(texte);
					fenetreGestionPersonnels.updateJTable();
				}
				else{
					String[] texte = {"L'utilisateur n'a pas pu être supprimé."};
					new JD_Information(texte);
				}
			}
		}

		public void ouvrirJP_Ajout_Personnels(){
			
			fenetreAjoutPersonnels = new JF_Ajout_Personnels();
		}
		
		public void ouvrirJP_Modifer_MDP(){
			Personnels personnel = fenetreGestionPersonnels.getSelectedItem_JT_listPersonnels();
			if(personnel == null){
				String[] texte = {"Veuillez selectionner un utilisateur."};
				new JD_Information(texte);
			}
			else{
				fenetreModifierMdp = new JF_Modifier_MDP();
			}
		}
		public void modifierMdp(String mdp){
			
			Personnels personnel = fenetreGestionPersonnels.getSelectedItem_JT_listPersonnels();
			String[] message = {"", ""};
			Boolean verif = true;
			
			if(mdp.length() < 6){
				verif = false;	
				message[0] = "Il faut un mot de passe d'un minimum de 6 caratères.";
			}
			else{
				if(personnel.getMotPasse().equals(mdp)){
					verif = false;	
					message[1] = "Le nouveau mot de passe ne peut pas être le même que l'ancien.";
				}
			}
		
			if(verif){	
				fenetreModifierMdp.dispose();
				int rs = personnelsDAO.UpdateMdpById(personnel.getCodePers(), mdp);
				
				if(rs > 0){
					String[] texte = {"Le mot de passe a été modifier."};
					fenetreGestionPersonnels.updateJTable();
					new JD_Information(texte);	
				}
				else{
					String[] texte = {"Le mot de passe n'a pas été modifer."};
					new JD_Information(texte);
				}
			}
			else{
				new JD_Information(message);
			}
		}

		public void enregistrerPersonnnel(Personnels personnels) {
			// TODO Auto-generated method stub

			personnelsDAO.addPersonnel(personnels);


			String[] message = {"", "", ""};
			Boolean verif = true;
			
			if(personnels.getNom().length() == 0){
				verif = false;	
				message[0] = "Il faut un nom.";
			}
			else{
				if(personnelsDAO.getNbPersonnelsByName(personnels.getNom()) > 0){
					verif = false;	
					message[2] = "Cet utilisateur existe déjâ.";
				}
			}
			if(personnels.getMotPasse().length() < 6){
				verif = false;	
				message[1] = "Il faut un mot de passe d'un min de 6 caratères.";
			}
		
			if(verif){
				fenetreAjoutPersonnels.dispose();
			
				int rs = personnelsDAO.addPersonnel(personnels);
				if(rs > 0){
					String[] texte = {"L'utilisateur a été ajouter."};
					fenetreGestionPersonnels.updateJTable();
					new JD_Information(texte);
				}
				else{
					String[] texte = {"L'utilisateur n'a pas pu être ajouté."};
					new JD_Information(texte);
				}
			}
			else{
				new JD_Information(message);
			}

		}
		

		// Ajoute un client	
		public void addClient() {
			try {
				clientDAO.insert(fenetreAddClient.client.getInputClient());
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ArrayList<Animaux> getListAnimaux() {
			// TODO Auto-generated method stub
			ArrayList<Animaux> desAnimaux = new ArrayList<Animaux>();
			try {
				
				desAnimaux =  animauxDAO.selectAllByClient(listClient.get(positionClient).getCodeClient());
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return desAnimaux;
		}
		

		
		//Affiche la liste des Clients et ses animaux
		public void display(int id) {		
			try {
				listClient = clientDAO.selectAll();
			
					switch (id) {
						case 0:
							positionClient = 0;
							break;
				
						case -2:
							positionClient = listClient.size()-1;
							break;
					
						case 1:
							if(positionClient < listClient.size() -1) {
								positionClient = positionClient +1;
							}
							break;
					
						case -1:
							if(positionClient > 0) {
								positionClient = positionClient -1;
							}
							break;
						default:
							break;
					}
					
					fenetreAddClient.client.displayClient(listClient.get(positionClient));
					fenetreAddClient.animal.updateJTable();

			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
}
