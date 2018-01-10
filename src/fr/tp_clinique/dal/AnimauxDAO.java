package fr.tp_clinique.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.tp_clinique.bo.Animaux;
import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.jdbc.JdbcTools;

public class AnimauxDAO {

	private static final String sqlSelectById = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents,Archive "
			+ "FROM dbo.Animaux WHERE CodeAnimal = ?";
	
	private static final String sqlSelectAll = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents,Archive "
			+ "FROM dbo.Animaux";
	
	private static final String sqlUpdate = "update dbo.Animaux set NomAnimal=?,Sexe=?,Couleur=?,Race=?,Espece=?,CodeClient=?,Tatouage=?,"
			+ "Antecedents=?,Archive=? where CodeAnimal=?";
	
	private static final String sqlInsert = "insert into dbo.Animaux(NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents,Archive) "
			+ "values(?,?,?,?,?,?,?,?,?)";
	
	private static final String sqlDelete = "delete from dbo.Animaux where CodeAnimal=?";
	

	
	public void insert(Animaux animal) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {

			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, animal.getNomAnimal());
			rqt.setString(2, animal.getSexe());
			rqt.setString(3, animal.getCouleur());
			rqt.setString(4, animal.getRace());
			rqt.setString(5, animal.getEspece());
			rqt.setInt(6, animal.getCodeClient());
			rqt.setString(7, animal.getTatouage());
			rqt.setString(8, animal.getAntecedents());
			rqt.setBoolean(9, animal.getArchive());
			
			int nbRows = rqt.executeUpdate();
			
			if(nbRows == 1){
				ResultSet rs = rqt.getGeneratedKeys();
				if(rs.next()){
					animal.setCodeAnimal(rs.getInt(1));
				}

			}
		}
		catch(SQLException e){
			throw new DALException("Insert animal failed - " + animal, e);
		}
	
		
	}

	public void update(Animaux animal) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {	
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			
			rqt.setString(1, animal.getNomAnimal());
			rqt.setString(2, animal.getSexe());
			rqt.setString(3, animal.getCouleur());
			rqt.setString(4, animal.getRace());
			rqt.setString(5, animal.getEspece());
			rqt.setInt(6, animal.getCodeClient());
			rqt.setString(7, animal.getTatouage());
			rqt.setString(8, animal.getAntecedents());
			rqt.setBoolean(9, animal.getArchive());
			rqt.setInt(10, animal.getCodeAnimal());
			
			rqt.executeUpdate();
		
		} catch (SQLException e) {
			throw new DALException("Update animal failed - " + animal, e);
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
	
	
	public Animaux selectById(int id) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Animaux animal = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectById);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();

			if (rs.next()){
			
				animal = new Animaux(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"),
						rs.getString("Sexe"),
						rs.getString("Couleur"),
						rs.getString("Race"),
						rs.getString("Espece"),
						rs.getInt("CodeClient"),
						rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("Archive")
						);
		}
		}catch (SQLException e) {
			throw new DALException("sqlSelectById Animal failed - " , e);
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
		System.out.println(animal);
		return animal;
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
			throw new DALException("Delete animal failed - id=" + id, e);
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

	public List<Animaux> selectAll() throws DALException {
		
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Animaux> liste = new ArrayList<Animaux>();
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			Animaux animal = null;
			
			while (rs.next()) {

				animal = new Animaux(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"),
						rs.getString("Sexe"),
						rs.getString("Couleur"),
						rs.getString("Race"),
						rs.getString("Espece"),
						rs.getInt("CodeClient"),
						rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("Archive"));

				liste.add(animal);
			}
		}catch (SQLException e) {
			throw new DALException("selectAll Animaux failed - " , e);
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
		System.out.println(liste);
		return liste;
	}
}
