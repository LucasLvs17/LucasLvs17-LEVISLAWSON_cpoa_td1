package RequetesSQL;

import Main.Connexion;
import java.sql.*;

public class ReqProduit {
	
	public void add(String id_produit, String nom, String description, Float tarif, String visuel, int id_categorie) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("INSERT INTO Produit(id_produit, nom, description, tarif, visuel,  id_categorie) VALUES ('" + id_produit + "," + nom + "', '" + description + "', '" + tarif + "', '" + visuel+ "', '" + id_categorie + "')");
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		
	}
	
	public void delete(int id_produit) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("DELETE FROM Produit WHERE id_produit = " + id_produit  + ";");
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		
	}
	
	
	public void updateNom(int id_produit, String nom) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Periodicite\n" + 
					"SET nom = '" + nom + "'\n" + 
					"WHERE id_produit=" + id_produit);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		
		
		
	}
}
