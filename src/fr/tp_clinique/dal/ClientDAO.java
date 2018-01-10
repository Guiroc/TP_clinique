package fr.tp_clinique.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.jdbc.JdbcTools;

public class ClientDAO {

	private static final String sqlSelectById = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance,Email, Remarque, Archive "
			+ "FROM dbo.Clients WHERE CodeCLient = ?";
	
	private static final String sqlSelectAll = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance,Email, Remarque, Archive "
			+ "FROM dbo.Clients";
	
	private static final String sqlUpdate = "update dbo.Clients set NomClient=?,PrenomClient=?,Adresse1=?,Adresse2=?,CodePostal=?,Ville=?,NumTel=?,"
			+ "Assurance=?,Email=?,Remarque=?,Archive=? where CodeClient=?";
	
	private static final String sqlInsert = "insert into dbo.Clients(NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance,Email, Remarque, Archive) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String sqlDelete = "delete from dbo.Clients where CodeClient=?";
	

	
	public void insert(Clients c) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, c.getClient());
			rqt.setString(2, c.getPrenomClient());
			rqt.setString(3, c.getAdresse1());
			rqt.setString(4, c.getAdresse2());
			rqt.setString(5, c.getCodePostal());
			rqt.setString(6, c.getVille());
			rqt.setString(7, c.getNumTel());
			rqt.setString(8, c.getAssurance());
			rqt.setString(9, c.getEmail());
			rqt.setString(10, c.getRemarque());
			rqt.setBoolean(11, c.getArchive());
			
			int nbRows = rqt.executeUpdate();
			if(nbRows == 1){
				ResultSet rs = rqt.getGeneratedKeys();
				if(rs.next()){
					c.setCodeClient(rs.getInt(1));
				}

			}
		}
		catch(SQLException e){
			throw new DALException("Insert clients failed - " + c, e);
		}
	
		
	}

	
	public void update(Clients c) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, c.getClient());
			rqt.setString(2, c.getPrenomClient());
			rqt.setString(3, c.getAdresse1());
			rqt.setString(4, c.getAdresse2());
			rqt.setString(5, c.getCodePostal());
			rqt.setString(6, c.getVille());
			rqt.setString(7, c.getNumTel());
			rqt.setString(8, c.getAssurance());
			rqt.setString(9, c.getEmail());
			rqt.setString(10, c.getRemarque());
			rqt.setBoolean(11, c.getArchive());
			rqt.setInt(12, c.getCodeClient());
			rqt.executeUpdate();
		
		} catch (SQLException e) {
			throw new DALException("Update client failed - " + c, e);
		} finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx !=null){
					cnx.close();
				}
			} catch (SQLException e) {					
				e.printStackTrace();
			}
		}
	}
	
	
	public void delete(int id) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, id);
			rqt.executeUpdate();
		}catch (SQLException e) {
			throw new DALException("Delete clients failed - id=" + id, e);
		} finally {
			try {
				if (rqt != null){
					rqt.close();		
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
	}
	
	
	public List<Clients> selectAll() throws DALException {
		
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Clients> liste = new ArrayList<Clients>();
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			Clients c = null;
			
			while (rs.next()) {

				c = new Clients(rs.getInt("CodeClient"),
				rs.getString("NomClient"),
				rs.getString("PrenomClient"),
				rs.getString("Adresse1"),
				rs.getString("Adresse2"),
				rs.getString("CodePostal"),
				rs.getString("Ville"),
				rs.getString("NumTel"),
				rs.getString("Assurance"),
				rs.getString("Email"),
				rs.getString("Remarque"));


				liste.add(c);
			}
		}catch (SQLException e) {
			throw new DALException("selectAll Clients failed - " , e);
		} finally {
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
		return liste;
	}
	
	
	public Clients selectById(int id) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients c = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectById);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();

			if (rs.next()){
			
				c = new Clients(rs.getInt("CodeClient"),
				rs.getString("NomClient"),
				rs.getString("PrenomClient"),
				rs.getString("Adresse1"),
				rs.getString("Adresse2"),
				rs.getString("CodePostal"),
				rs.getString("Ville"),
				rs.getString("NumTel"),
				rs.getString("Assurance"),
				rs.getString("Email"),
				rs.getString("Remarque"));
				
			}
		}catch (SQLException e) {
			throw new DALException("sqlSelectById Clients failed - " , e);
		} finally {
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
		return c;
	}

}








