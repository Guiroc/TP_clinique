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
			+ "Assurance=?,Email=?,Remarque=?,Archive=?, where CodeClient=?";
	
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
	
}

//@Override
//public List<Article> selectAll() throws DALException {
//	Connection cnx = null;
//	Statement rqt = null;
//	ResultSet rs = null;
//	List<Article> liste = new ArrayList<Article>();
//	try {
//		cnx = JdbcTools.getConnection();
//		rqt = cnx.createStatement();
//		rs = rqt.executeQuery(sqlSelectAll);
//		Article art = null;
//
//		while (rs.next()) {
//			if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())){
//
//				art = new Stylo(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getString("couleur"));
//			}
//			if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())){
//				art = new Ramette(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getInt("grammage"));
//			}
//			liste.add(art);
//		}
//	} catch (SQLException e) {
//		throw new DALException("selectAll failed - " , e);
//	} finally {
//		try {
//			if (rs != null){
//				rs.close();
//			}
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx!=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	return liste;
//
//}



//@Override
//public Article selectById(int id) throws DALException {
//	Connection cnx = null;
//	PreparedStatement rqt = null;
//	ResultSet rs = null;
//	Article art = null;
//	try {
//		cnx = JdbcTools.getConnection();
//		rqt = cnx.prepareStatement(sqlSelectById);
//		rqt.setInt(1, id);
//
//		rs = rqt.executeQuery();
//		if (rs.next()){
//
//			if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())){
//
//				art = new Stylo(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getString("couleur"));
//			}
//			if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())){
//				art = new Ramette(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getInt("grammage"));
//			}
//		}
//
//	} catch (SQLException e) {
//		throw new DALException("selectById failed - id = " + id , e);
//	} finally {
//		try {
//			if (rs != null){
//				rs.close();
//			}
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx!=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//	return art;
//}
//
//@Override
//public List<Article> selectAll() throws DALException {
//	Connection cnx = null;
//	Statement rqt = null;
//	ResultSet rs = null;
//	List<Article> liste = new ArrayList<Article>();
//	try {
//		cnx = JdbcTools.getConnection();
//		rqt = cnx.createStatement();
//		rs = rqt.executeQuery(sqlSelectAll);
//		Article art = null;
//
//		while (rs.next()) {
//			if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())){
//
//				art = new Stylo(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getString("couleur"));
//			}
//			if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())){
//				art = new Ramette(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getInt("grammage"));
//			}
//			liste.add(art);
//		}
//	} catch (SQLException e) {
//		throw new DALException("selectAll failed - " , e);
//	} finally {
//		try {
//			if (rs != null){
//				rs.close();
//			}
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx!=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	return liste;
//
//}
//
//
//
//@Override
//public void update(Article data) throws DALException {
//	Connection cnx = null;
//	PreparedStatement rqt = null;
//	try {
//		cnx = JdbcTools.getConnection();
//		rqt = cnx.prepareStatement(sqlUpdate);
//		rqt.setString(1, data.getReference());
//		rqt.setString(2, data.getMarque());
//		rqt.setString(3, data.getDesignation());
//		rqt.setFloat(4, data.getPrixUnitaire());
//		rqt.setInt(5, data.getQteStock());
//		rqt.setInt(8, data.getIdArticle());
//		if (data instanceof Ramette) {
//			Ramette r = (Ramette) data;
//			rqt.setInt(6, r.getGrammage());
//			rqt.setNull(7, Types.VARCHAR);
//		}
//		if (data instanceof Stylo) {
//			Stylo s = (Stylo) data;
//			rqt.setNull(6, Types.INTEGER);
//			rqt.setString(7, s.getCouleur());
//		}
//
//		rqt.executeUpdate();
//
//	} catch (SQLException e) {
//		throw new DALException("Update article failed - " + data, e);
//	} finally {
//		try {
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx !=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}
//
//@Override
//public void insert(Article data) throws DALException {
//	Connection cnx = null;
//	PreparedStatement rqt = null;
//	try {
//		cnx = JdbcTools.getConnection();
//		rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
//		rqt.setString(1, data.getReference());
//		rqt.setString(2, data.getMarque());
//		rqt.setString(3, data.getDesignation());
//		rqt.setFloat(4, data.getPrixUnitaire());
//		rqt.setInt(5, data.getQteStock());
//		if (data instanceof Ramette) {
//			Ramette r= (Ramette) data;
//			rqt.setString(6, TYPE_RAMETTE);
//			rqt.setInt(7, r.getGrammage());
//			rqt.setNull(8, Types.VARCHAR);
//		}
//		if (data instanceof Stylo) {
//			Stylo s = (Stylo) data;
//			rqt.setString(6, TYPE_STYLO);
//			rqt.setNull(7, Types.INTEGER);
//			rqt.setString(8, s.getCouleur());
//		}
//
//		int nbRows = rqt.executeUpdate();
//		if(nbRows == 1){
//			ResultSet rs = rqt.getGeneratedKeys();
//			if(rs.next()){
//				data.setIdArticle(rs.getInt(1));
//			}
//
//		}
//
//	}catch(SQLException e){
//		throw new DALException("Insert article failed - " + data, e);
//	}
//	finally {
//		try {
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx!=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			throw new DALException("close failed - ", e);
//		}
//
//	}
//}
//
//
//
//
//
//@Override
//public void delete(int id) throws DALException {
//	Connection cnx = null;
//	PreparedStatement rqt = null;
//	try {		
//		cnx = JdbcTools.getConnection();
//		//l'intégrité référentielle s'occupe d'invalider la suppression
//		//si l'article est référencé dans une ligne de commande
//		rqt = cnx.prepareStatement(sqlDelete);
//		rqt.setInt(1, id);
//		rqt.executeUpdate();
//	} catch (SQLException e) {
//		throw new DALException("Delete article failed - id=" + id, e);
//	} finally {
//		try {
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx!=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			throw new DALException("close failed " , e);
//		}
//
//	}		
//}
//
//@Override
//public List<Article> selectByMarque(String marque) throws DALException {
//	Connection cnx = null;
//	PreparedStatement rqt = null;
//	ResultSet rs = null;
//	List<Article> liste = new ArrayList<Article>();
//	try {
//		cnx = JdbcTools.getConnection();
//		rqt = cnx.prepareStatement(sqlSelectByMarque);
//		rqt.setString(1, marque);
//		rs = rqt.executeQuery();
//		Article art = null;
//
//		while (rs.next()) {
//			if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())){
//
//				art = new Stylo(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getString("couleur"));
//			}
//			if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())){
//				art = new Ramette(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getInt("grammage"));
//			}
//			liste.add(art);
//		}
//	} catch (SQLException e) {
//		throw new DALException("selectByMarque failed - " , e);
//	} finally {
//		try {
//			if (rs != null){
//				rs.close();
//			}
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx!=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			throw new DALException("close failed " , e);
//		}
//	}
//	return liste;
//}
//
//@Override
//public List<Article> selectByMotCle(String motCle) throws DALException {
//	Connection cnx = null;
//	PreparedStatement rqt = null;
//	ResultSet rs = null;
//	List<Article> liste = new ArrayList<Article>();
//	try {
//		cnx = JdbcTools.getConnection();
//		rqt = cnx.prepareStatement(sqlSelectByMotCle);
//		rqt.setString(1, motCle);
//		rs = rqt.executeQuery();
//		Article art = null;
//
//		while (rs.next()) {
//			if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())){
//
//				art = new Stylo(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getString("couleur"));
//			}
//			if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())){
//				art = new Ramette(rs.getInt("idArticle"),
//						rs.getString("marque"),
//						rs.getString("reference").trim(),
//						rs.getString("designation"),
//						rs.getFloat("prixUnitaire"),
//						rs.getInt("qteStock"),
//						rs.getInt("grammage"));
//			}
//			liste.add(art);
//		}
//	} catch (SQLException e) {
//		throw new DALException("selectByMotCle failed - " , e);
//	} finally {
//		try {
//			if (rs != null){
//				rs.close();
//			}
//			if (rqt != null){
//				rqt.close();
//			}
//			if(cnx!=null){
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			throw new DALException("close failed " , e);
//		}
//	}
//	return liste;
//}