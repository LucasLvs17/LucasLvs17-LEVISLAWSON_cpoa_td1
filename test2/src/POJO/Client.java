package POJO;

public class Client {
	
	private int id_client;
	private String nom;
	private String prenom;
	private String identifiant;
	private String mot_de_passe;
	private String adr_numero;
	private String adr_voie;
	private String adr_code_postal;
	private String adr_ville;
	private String adr_pays;
	
	
	
	public Client(int id_client, String nom, String prenom, String identifiant, String mot_de_passe, String adr_numero,
			String adr_voie, String adr_code_postal, String adr_ville, String adr_pays) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.mot_de_passe = mot_de_passe;
		this.adr_numero = adr_numero;
		this.adr_voie = adr_voie;
		this.adr_code_postal = adr_code_postal;
		this.adr_ville = adr_ville;
		this.adr_pays = adr_pays;
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
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
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getAdr_numero() {
		return adr_numero;
	}
	public void setAdr_numero(String adr_numero) {
		this.adr_numero = adr_numero;
	}
	public String getAdr_voie() {
		return adr_voie;
	}
	public void setAdr_voie(String adr_voie) {
		this.adr_voie = adr_voie;
	}
	public String getAdr_code_postal() {
		return adr_code_postal;
	}
	public void setAdr_code_postal(String adr_code_postal) {
		this.adr_code_postal = adr_code_postal;
	}
	public String getAdr_ville() {
		return adr_ville;
	}
	public void setAdr_ville(String adr_ville) {
		this.adr_ville = adr_ville;
	}
	public String getAdr_pays() {
		return adr_pays;
	}
	public void setAdr_pays(String adr_pays) {
		this.adr_pays = adr_pays;
	}
	
	public String toString() {
		return + this.id_client + this.nom + this.prenom + this.adr_voie + this.adr_code_postal + this.adr_ville + this.adr_pays ;
	}

}
