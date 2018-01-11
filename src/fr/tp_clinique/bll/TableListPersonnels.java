package fr.tp_clinique.bll;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fr.tp_clinique.bo.Personnels;

public class TableListPersonnels extends AbstractTableModel {
 
	private static final long serialVersionUID = 1L;
	private ArrayList<Personnels> list;
 
	public TableListPersonnels(ArrayList<Personnels> list) {
		this.list = list;
	}
 
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return getData(list.get(rowIndex), columnIndex);
	}
 
	public Object getData(Personnels personnels, int col) {
		switch (col) {
			case 0: {
				return personnels.getNom();
			}
			case 1: {
				return personnels.getRole();
			}
			case 2: {
				return "********";
			}
		}
		return null;
	}
 
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0: {
			return "Nom & Prénoms";
		}
		case 1: {
			return "Rôle";
		}
		case 2: {
			return "Mot de passe";
		}
		}
		return "";
	}
 
	@Override
	public int getRowCount() {
		return list.size(); // le nombre de lignes
	}
 
	@Override
	public int getColumnCount() {
		return 3; // le nombre de colonnes
	}
	
 
}