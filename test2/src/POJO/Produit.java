package POJO;

public class Produit {

	private int id_produit;
	private String nom;
	private String description;
	private double tarif;
	private String visuel;
	private int id_categorie;
	
	
	
	public Produit(int id_produit, String nom, String description, double tarif, String visuel, int id_categorie) {
		super();
		this.id_produit = id_produit;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.id_categorie = id_categorie;
	}
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	
	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", nom=" + nom + ", description=" + description + ", tarif="
				+ tarif + ", visuel=" + visuel + ", id_categorie=" + id_categorie + "]";
	}
	
	
}