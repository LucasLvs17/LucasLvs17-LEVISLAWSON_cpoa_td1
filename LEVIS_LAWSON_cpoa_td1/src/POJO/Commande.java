package POJO;
import java.time.LocalDate;

public class Commande {
	
	private int id_commande;
	private LocalDate date_commande;
	private int id_client;
	
	
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public LocalDate getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(LocalDate date_commande) {
		this.date_commande = date_commande;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	
	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", date_commande=" + date_commande + ", id_client=" + id_client
				+ "]";
	}

}
