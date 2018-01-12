package fr.tp_clinique.dal;


public class DAOFactory {
	
	public static PersonnelsDAO getPersonnelsDAO()  {
		PersonnelsDAO personnelsDAO = null;
		try {
			personnelsDAO = (PersonnelsDAO) Class.forName("fr.tp_clinique.dal.PersonnelsDAO").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personnelsDAO; 
	}

	public static ClientDAO getClientDAO()  {
		ClientDAO clientDAO = null;
		try {
			clientDAO = (ClientDAO) Class.forName("fr.tp_clinique.dal.ClientDAO").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientDAO; 
	}
	
	public static AnimauxDAO getAnimauxDAO()  {
		AnimauxDAO animauxDAO = null;
		try {
			animauxDAO = (AnimauxDAO) Class.forName("fr.tp_clinique.dal.AnimauxDAO").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animauxDAO; 
	}
}