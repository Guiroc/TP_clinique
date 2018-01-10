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
	private static final String sql_deleteById = "delete from personnels where CodePers = ?";
	private static final String sql_addById = "insert into personnels (Nom, MotPasse, Role, Archive) values (?, ?, ?, ?)";

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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return desPersonne;
	}

public void DeletePersonnelsById(int codePers) {
	// TODO Auto-generated method stub
	Connection cnx = null;
	PreparedStatement rqt = null;
	
	try {

		cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sql_deleteById);
		rqt.setInt(1, codePers);
		
		int rs = rqt.executeUpdate();

	}
	catch(SQLException e){
		e.printStackTrace();
	}
}

public void addPersonnel(Personnels personnels) {
	// TODO Auto-generated method stub
	Connection cnx = null;
	PreparedStatement rqt = null;
	
	try {

		cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sql_addById);
		rqt.setString(1, personnels.getNom());
		rqt.setString(2, personnels.getMotPasse());
		rqt.setString(3, personnels.getRole());
		rqt.setBoolean(4,  personnels.getArchive());
		
		int rs = rqt.executeUpdate();

	}
	catch(SQLException e){
		e.printStackTrace();
	}
}

}
