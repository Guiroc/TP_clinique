package fr.tp_clinique.bo;

public class Animaux {

	int CodeAnimal;
	String NomAnimal;
	String Sexe;
	String Couleur;
	String Race;
	String Espece;
	int CodeClient;
	String Tatouage;
	String Antecedents;
	Boolean Archive;
	
	
	public Animaux(int codeAnimal, String nomAnimal, String sexe,
			String couleur, String race, String espece, int codeClient,
			String tatouage, String antecedents) {
		super();
		this.CodeAnimal = codeAnimal;
		this.NomAnimal = nomAnimal;
		this.Sexe = sexe;
		this.Couleur = couleur;
		this.Race = race;
		this.Espece = espece;
		this.CodeClient = codeClient;
		this.Tatouage = tatouage;
		this.Antecedents = antecedents;
		this.Archive = false;
	}


	public int getCodeAnimal() {
		return CodeAnimal;
	}

	public String getNomAnimal() {
		return NomAnimal;
	}

	public void setNomAnimal(String nomAnimal) {
		NomAnimal = nomAnimal;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getEspece() {
		return Espece;
	}

	public void setEspece(String espece) {
		Espece = espece;
	}

	public int getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}

	public String getTatouage() {
		return Tatouage;
	}

	public void setTatouage(String tatouage) {
		Tatouage = tatouage;
	}

	public String getAntecedents() {
		return Antecedents;
	}

	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}


	@Override
	public String toString() {
		return "Animaux [CodeAnimal=" + CodeAnimal + ", NomAnimal=" + NomAnimal
				+ ", Sexe=" + Sexe + ", Couleur=" + Couleur + ", Race=" + Race
				+ ", Espece=" + Espece + ", CodeClient=" + CodeClient
				+ ", Tatouage=" + Tatouage + ", Antecedents=" + Antecedents
				+ ", Archive=" + Archive + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
