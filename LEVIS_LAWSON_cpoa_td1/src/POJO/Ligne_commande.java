package POJO;

public class Ligne_commande {

	private int id_commande;
	private int id_produit;
	private int quantite;
	private double tarif;
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	@Override
	public String toString() {
		return "Ligne_commande [id_commande=" + id_commande + ", id_produit=" + id_produit + ", quantite=" + quantite
				+ ", tarif=" + tarif + "]";
	}
	
	
}
