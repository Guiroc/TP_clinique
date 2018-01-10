package fr.tp_clinique.bo;

import java.util.ArrayList;

public class Clients {
	int CodeClient;
	String Client;
	String PrenomClient;
	String Adresse1;
	String Adresse2;
	String CodePostal;
	String Ville;
	String NumTel;
	String Assurance;
	String Email;
	String Remarque;
	Boolean Archive;
	ArrayList<Animaux> lesAnimaux;
	
	public Clients(int codeClient, String client, String prenomClient,
			String adresse1, String adresse2, String codePostal, String ville,
			String numTel, String assurance, String email, String remarque) {
		
		this.CodeClient = codeClient;
		this.Client = client;
		this.PrenomClient = prenomClient;
		this.Adresse1 = adresse1;
		this.Adresse2 = adresse2;
		this.CodePostal = codePostal;
		this.Ville = ville;
		this.NumTel = numTel;
		this.Assurance = assurance;
		this.Email = email;
		this.Remarque = remarque;
		this.Archive = false;
		this.lesAnimaux = new ArrayList<Animaux>();
	}
	
	public Clients(String client, String prenomClient,
			String adresse1, String adresse2, String codePostal, String ville,
			String numTel, String assurance, String email, String remarque) {
		
		
		this.Client = client;
		this.PrenomClient = prenomClient;
		this.Adresse1 = adresse1;
		this.Adresse2 = adresse2;
		this.CodePostal = codePostal;
		this.Ville = ville;
		this.NumTel = numTel;
		this.Assurance = assurance;
		this.Email = email;
		this.Remarque = remarque;
		this.lesAnimaux = new ArrayList<Animaux>();
	}

	public int getCodeClient() {
		return CodeClient;
	}

	public String getClient() {
		return Client;
	}

	public String getPrenomClient() {
		return PrenomClient;
	}

	public String getAdresse1() {
		return Adresse1;
	}

	public String getAdresse2() {
		return Adresse2;
	}

	public String getCodePostal() {
		return CodePostal;
	}

	public String getVille() {
		return Ville;
	}

	public String getNumTel() {
		return NumTel;
	}

	public String getAssurance() {
		return Assurance;
	}

	public String getEmail() {
		return Email;
	}

	public String getRemarque() {
		return Remarque;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}

	public void setClient(String client) {
		Client = client;
	}

	public void setPrenomClient(String prenomClient) {
		PrenomClient = prenomClient;
	}

	public void setAdresse1(String adresse1) {
		Adresse1 = adresse1;
	}

	public void setAdresse2(String adresse2) {
		Adresse2 = adresse2;
	}

	public void setCodePostal(String codePostal) {
		CodePostal = codePostal;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}

	public void setAssurance(String assurance) {
		Assurance = assurance;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setRemarque(String remarque) {
		Remarque = remarque;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	public ArrayList<Animaux> getLesAnimaux() {
		return lesAnimaux;
	}

	public void setLesAnimaux(ArrayList<Animaux> lesAnimaux) {
		this.lesAnimaux = lesAnimaux;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clients [CodeClient=");
		builder.append(CodeClient);
		builder.append(", Client=");
		builder.append(Client);
		builder.append(", PrenomClient=");
		builder.append(PrenomClient);
		builder.append(", Adresse1=");
		builder.append(Adresse1);
		builder.append(", Adresse2=");
		builder.append(Adresse2);
		builder.append(", CodePostal=");
		builder.append(CodePostal);
		builder.append(", Ville=");
		builder.append(Ville);
		builder.append(", NumTel=");
		builder.append(NumTel);
		builder.append(", Assurance=");
		builder.append(Assurance);
		builder.append(", Email=");
		builder.append(Email);
		builder.append(", Remarque=");
		builder.append(Remarque);
		builder.append(", Archive=");
		builder.append(Archive);
		builder.append("]");
		return builder.toString();
	}
	
}
