package fr.tp_clinique.bll;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fr.tp_clinique.bo.Animaux;
import fr.tp_clinique.bo.Personnels;

public class TableListAnimaux extends AbstractTableModel {

		 
		private static final long serialVersionUID = 1L;
		private ArrayList<Animaux> list;
	 
		public TableListAnimaux(ArrayList<Animaux> list) {
			this.list = list;
		}
	 
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return getData(list.get(rowIndex), columnIndex);
		}
	 
		public Object getData(Animaux animal, int col) {
			switch (col) {
				case 0: {
					return animal.getCodeClient();
				}
				case 1: {
					return animal.getNomAnimal();
				}
				case 2: {
					return animal.getSexe();
				}
				
				case 3: {
					return animal.getCouleur();
				}
				
				case 4: {
					return animal.getRace();
				}
				
				case 5: {
					return animal.getEspece();
				}
				
				case 6: {
					return animal.getTatouage();
				}
			}
			return null;
		}
	 
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0: {
				return "Numéro";
			}
			case 1: {
				return "Nom";
			}
			case 2: {
				return "Sexe";
			}
			case 3: {
				return "Couleur";
			}
			case 4: {
				return "Race";
			}
			case 5: {
				return "Espece";
			}
			case 6: {
				return "Tatouage";
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
			return 7; // le nombre de colonnes
		}
		
		public void update(ArrayList<Animaux> desAnimaux) {
			this.list = desAnimaux;
		}

}
