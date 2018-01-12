package fr.tp_clinique.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.crypto.provider.RSACipher;

import fr.tp_clinique.bo.Personnels;
import fr.tp_clinique.dal.jdbc.JdbcTools;

public class PersonnelsDAO {
	
	private static final String sql_connexion = "select * from personnels where Nom = ? and MotPasse = ?";
	private static final String sql_selectPersonnelsByName = "select count(*) as nb from personnels where Nom = ?";
	private static final String sql_selectNotArchive = "select * from personnels";
	private static final String sql_deleteById = "delete from personnels where CodePers = ?";
	private static final String sql_addById = "insert into personnels (Nom, MotPasse, Role, Archive) values (?, ?, ?, ?)";
	private static final String sql_UpdateMdpById = "update personnels set MotPasse = ? where CodePers = ?";

	public Personnels getUnPersonnel(String login, String mdp){
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		Personnels unePersonne = null;
		ResultSet rs = null;
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sql_connexion);
			rqt.setString(1, login);
			rqt.setString(2, mdp);
			
			rs = rqt.executeQuery();
			if(rs.next()){
				unePersonne = new Personnels(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"), rs.getString("Role"), rs.getBoolean("Archive"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return unePersonne;
	}
	
public int getNbPersonnelsByName(String login){
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		int nb = 0;
		ResultSet rs = null;
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sql_selectPersonnelsByName);
			rqt.setString(1, login);
			
			rs = rqt.executeQuery();
			if(rs.next()){
				nb = rs.getInt("nb");
				System.out.println(nb);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nb;
	}

public ArrayList<Personnels> getNotArchivePersonnels() {
		// TODO Auto-generated method stub
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ArrayList<Personnels> desPersonne = new ArrayList<Personnels>();
		ResultSet rs = null;
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sql_selectNotArchive);
			
			rs = rqt.executeQuery();
			while(rs.next()){
				desPersonne.add(new Personnels(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"), rs.getString("Role"), rs.getBoolean("Archive")));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return desPersonne;
	}

public int DeletePersonnelsById(int codePers){
	// TODO Auto-generated method stub
	Connection cnx = null;
	PreparedStatement rqt = null;
	int rs = 0;
	
	try {

		cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sql_deleteById);
		rqt.setInt(1, codePers);
		
		rs = rqt.executeUpdate();

	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		try {
			if (rqt != null){
				rqt.close();
			}
			if(cnx!=null){
				cnx.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return rs;
}

public int addPersonnel(Personnels personnels){
	// TODO Auto-generated method stub
	Connection cnx = null;
	PreparedStatement rqt = null;
	int rs = 0;
	
	try {

		cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sql_addById);
		rqt.setString(1, personnels.getNom());
		rqt.setString(2, personnels.getMotPasse());
		rqt.setString(3, personnels.getRole());
		rqt.setBoolean(4,  personnels.getArchive());
		
		rs = rqt.executeUpdate();

	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		try {
			if (rqt != null){
				rqt.close();
			}
			if(cnx!=null){
				cnx.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return rs;
}

public int UpdateMdpById(int codePers, String mdp) {
	// TODO Auto-generated method stub
	Connection cnx = null;
	PreparedStatement rqt = null;
	int rs = 0;
	
	try {

		cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sql_UpdateMdpById);
		rqt.setString(1, mdp);
		rqt.setInt(2, codePers);
		
		rs = rqt.executeUpdate();

	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		try {
			if (rqt != null){
				rqt.close();
			}
			if(cnx!=null){
				cnx.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return rs;
}

}
