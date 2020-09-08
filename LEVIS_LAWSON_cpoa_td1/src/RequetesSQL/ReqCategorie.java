package RequetesSQL;

import Main.Connexion;
import java.sql.*;

public class ReqCategorie{
	
	public void add(int id_categorie, String titre, String visuel) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("INSERT INTO Revue VALUES ('" + id_categorie + "', "
					+ ""+ titre +","
					+ ""  + visuel +")");
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

	public void delete(int id_categorie, String titre, String visuel) {
		try {
			Connexion laConnexion = new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("DELETE FROM Categorie VALUES('" + id_categorie + "',"
					+ " " + ""+ titre +","
					+ "" + visuel +")");
			co.close();
		} catch (SQLException sqle){
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	public void modify(int id_categorie, String titre, String visuel) {
		try {
			Connexion laConnexion = new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Categorie VALUES('" + id_categorie + "',"
					+ " " + ""+ titre +","
					+ "" + visuel +")");
			co.close();
		} catch(SQLException sqle){
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
}