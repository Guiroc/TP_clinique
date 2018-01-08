package fr.tp_clinique.bo;

import java.util.Date;

public class Agendas {
	int CodeVeto;
	Date DateRdv;
	int CodeAnimal;
	
	public Agendas(int codeVeto, Date dateRdv, int codeAnimal) {
		super();
		CodeVeto = codeVeto;
		DateRdv = dateRdv;
		CodeAnimal = codeAnimal;
	}

	public int getCodeVeto() {
		return CodeVeto;
	}

	public Date getDateRdv() {
		return DateRdv;
	}

	public int getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeVeto(int codeVeto) {
		CodeVeto = codeVeto;
	}

	public void setDateRdv(Date dateRdv) {
		DateRdv = dateRdv;
	}

	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agendas [CodeVeto=");
		builder.append(CodeVeto);
		builder.append(", DateRdv=");
		builder.append(DateRdv);
		builder.append(", CodeAnimal=");
		builder.append(CodeAnimal);
		builder.append("]");
		return builder.toString();
	}
	
	
}
