package fr.tp_clinique.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.tp_clinique.bo.Personnels;
import fr.tp_clinique.dal.jdbc.JdbcTools;

public class PersonnelsDAO {
	
	private static final String sql_connexion = "select * from personnels where Nom = ? and MotPasse = ?";
	private static final String sql_selectNotArchive = "select * from personnels";

	public Personnels getUnPersonnel(String login, String mdp) {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		Personnels unePersonne = null;
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sql_connexion);
			rqt.setString(1, login);
			rqt.setString(2, mdp);
			
			ResultSet rs = rqt.executeQuery();
			if(rs.next()){
				unePersonne = new Personnels(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"), rs.getString("Role"), rs.getBoolean("Archive"));
			}
		}
		catch(SQLException e){
			
		}
		return unePersonne;
	}

public ArrayList<Personnels> getNotArchivePersonnels() {
		// TODO Auto-generated method stub
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ArrayList<Personnels> desPersonne = new ArrayList<Personnels>();
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sql_selectNotArchive);
			
			ResultSet rs = rqt.executeQuery();
			while(rs.next()){
				desPersonne.add(new Personnels(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"), rs.getString("Role"), rs.getBoolean("Archive")));
			}
		}
		catch(SQLException e){
			
		}
		return desPersonne;
	}

}
