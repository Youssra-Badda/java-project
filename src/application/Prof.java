package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prof {
	private String nom;
	private String prenom;
	private String emailc;
	private String emailp;
	private String adresse;
	private String tel;
	private String date;
	private String ppr;
	
	public Prof(String nom,String p,String ec,String ep,String adr,String tel,String date,String ppr)
	{
		this.nom=nom;
		this.prenom=p;
		this.emailc=ec;
		this.emailp=ep;
		this.adresse=adr;
		this.tel=tel;
		this.date=date;
		this.ppr=ppr;
	}
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	public String getPrenom()
	{
		return prenom;
	}
	public void setPrenom(String nom)
	{
		this.prenom=nom;
	}
	public String getEmailc()
	{
		return emailc;
	}
	public void setEmailc(String nom)
	{
		this.emailc=nom;
	}
	public String getEmailp()
	{
		return emailp;
	}
	public void setEmailp(String nom)
	{
		this.emailp=nom;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String nom)
	{
		this.tel=nom;
	}
	public String getAdresse()
	{
		return adresse;
	}
	public void setAdresse(String nom)
	{
		this.adresse=nom;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String nom)
	{
		this.date=nom;
	}
	public String getPpr()
	{
		return ppr;
	}
	public void setPpr(String nom)
	{
		this.ppr=nom;
	}
//	public String nomProperty() {
//        return nom;
//    }
//	private final StringProperty noms = new SimpleStringProperty();
//	public final StringProperty projectProperty() {
//	   return noms;
//	}
//
//	public final String getProject() {
//	   return noms.get();
//	}
//
//	public final void setProject(String value) {
//	    noms.set(value);
//	}

}
