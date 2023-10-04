package application;

public class Cours {
	   private int idDoc;
       private String titre;
       private String type;
       private String profs;
//       private String visibilite;
       private String file;
       private String niveau;
       private String module;
       private String date;//int idDoc,
	public Cours(String titre, String type, String profs, int idDoc, String file, String niveau, String module,
			String date) {
		super();
		this.idDoc = idDoc;
		this.titre = titre;
		this.type = type;
		this.profs = profs;

		this.file = file;
		this.niveau = niveau;
		this.module = module;
		this.date = date;
	}
	public int getId() {
		return idDoc;
	}
	public void setId(int id) {
		this.idDoc = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProfs() {
		return profs;
	}
	public void setProfs(String profs) {
		this.profs = profs;
	}
//	public String getVisibilite() {
//		return visibilite;
//	}
//	public void setVisibilite(String visibilite) {
//		this.visibilite = visibilite;
//	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
       
      
}
