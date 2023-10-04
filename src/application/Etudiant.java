package application;

public class Etudiant {
      private String CNE;
      private String nom;
      private String prenom;
      private String emailA;
      private String emailP;
	public Etudiant(String cNE, String nom, String prenom, String emailA, String emailP) {
		super();
		CNE = cNE;
		this.nom = nom;
		this.prenom = prenom;
		this.emailA = emailA;
		this.emailP = emailP;
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmailA() {
		return emailA;
	}
	public void setEmailA(String emailA) {
		this.emailA = emailA;
	}
	public String getEmailP() {
		return emailP;
	}
	public void setEmailP(String emailP) {
		this.emailP = emailP;
	}
     
      
}
