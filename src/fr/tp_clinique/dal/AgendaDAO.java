package fr.tp_clinique.dal;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.tp_clinique.bo.Agendas;
import fr.tp_clinique.bo.Animaux;
import fr.tp_clinique.bo.Clients;
import fr.tp_clinique.dal.jdbc.JdbcTools;

public class AgendaDAO {
	
	
	private static final String sqlSelectAll = "SELECT CodeVeto, DateRdv, CodeAnimal FROM dbo.Agendas";

	
	private static final String sqlInsert = "insert into dbo.Agendas(CodeVeto,DateRdv, CodeAnimal) values(?,?,?)";
	
	private static final String sqlDelete = "delete from dbo.Agendas where CodeVeto=? and DateRdv=? and CodeAnimal=?";
	

	
	public void insert(Agendas rdv) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			rqt.setInt(1, rdv.getCodeVeto());
			rqt.setDate(2, (Date) rdv.getDateRdv());
			rqt.setInt(3, rdv.getCodeAnimal());
			rqt.executeUpdate();
		}
		catch(SQLException e){
			throw new DALException("Insert rdv failed - " + rdv, e);
		}
	
		
	}

	public void delete(Agendas rdv) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, rdv.getCodeVeto());
			rqt.setDate(2, (Date) rdv.getDateRdv());
			rqt.setInt(3, rdv.getCodeAnimal());
			rqt.executeUpdate();
			
		}catch (SQLException e) {
			throw new DALException("Delete rdv failed - id=" + rdv, e);
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

	
	
	public List<Agendas> selectAll() throws DALException {
		
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Agendas> liste = new ArrayList<Agendas>();
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			Agendas rdv = null;
			
			while (rs.next()) {
				
				rdv = new Agendas(rs.getInt("CodeVeto"),rs.getDate("DateRdv"),rs.getInt("CodeAnimal"));

				liste.add(rdv);
			}
		}catch (SQLException e) {
			throw new DALException("selectAll Rdv failed - " , e);
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
