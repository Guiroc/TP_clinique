package fr.tp_clinique.bo;

public class Personnels {

		int codePers;
		
		String nom,
			motPasse,
			role;
		
		Boolean archive;

		public Personnels(int codePers, String nom, String motPasse, String role) {
			this.codePers = codePers;
			this.nom = nom;
			this.motPasse = motPasse;
			this.role = role;
			this.archive = false;
		}

		public Personnels(int codePers, String nom, String motPasse, String role, boolean archive) {
			this.codePers = codePers;
			this.nom = nom;
			this.motPasse = motPasse;
			this.role = role;
			this.archive = archive;
		}

		public Personnels(String nom, String role, String motPasse) {
			// TODO Auto-generated constructor stub
			this.nom = nom;
			this.motPasse = motPasse;
			this.role = role;
			this.archive = false;
		}

		public int getCodePers() {
			return codePers;
		}

		public String getNom() {
			return nom;
		}

		public String getMotPasse() {
			return motPasse;
		}

		public String getRole() {
			return role;
		}

		public Boolean getArchive() {
			return archive;
		}

		public void setCodePers(int codePers) {
			this.codePers = codePers;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public void setMotPasse(String motPasse) {
			this.motPasse = motPasse;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public void setArchive(Boolean archive) {
			this.archive = archive;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Personnels [codePers=");
			builder.append(codePers);
			builder.append(", nom=");
			builder.append(nom);
			builder.append(", motPasse=");
			builder.append(motPasse);
			builder.append(", role=");
			builder.append(role);
			builder.append(", archive=");
			builder.append(archive);
			builder.append("]");
			return builder.toString();
		}
		
		
}
