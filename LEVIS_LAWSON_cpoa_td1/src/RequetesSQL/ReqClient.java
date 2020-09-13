package RequetesSQL;

import Main.Connexion;
import java.sql.*;

public class ReqClient {

	public void add(int id_client, String nom, String prenom, String identifiant, String mot_de_passe, int adr_numero, String adr_voie, String adr_code_postal, String adr_ville, String adr_pays) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("INSERT INTO Client(id_client, nom, prenom, idendifiant, mot_de_passe,  adr_rue, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES ('" + id_client + "," + nom + "', '" + prenom + "', '" + identifiant + "', '" + mot_de_passe + "', '" + adr_numero + "', '" + adr_voie + "', '" + adr_code_postal + "', '" + adr_ville + "', '" + adr_pays + "')");
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		
	}
	
	public void delete(int id_client) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("DELETE FROM Client WHERE id_client = " + id_client  + ";");
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		
		
		
	}
	
	
	public void update_nom(int id_client, String nom) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET nom = '" + nom + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	
	
	public void update_prenom(int id_client, String prenom) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET prenom = '" + prenom + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	
	public void update_adr_numero(int id_client, int no) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET adr_numero = '" + no + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	
	
	public void update_adr_voie(int id_client, String adr_voie) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET adr_voie = '" + adr_voie + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	
	
	public void update_adr_code_postal(int id_client, String cp) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET adr_code_postal = '" + cp + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	public void update_adr_ville(int id_client, String adr_ville) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET adr_ville = '" + adr_ville + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	public void update_adr_pays(int id_client, String adr_pays) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET adr_pays = '" + adr_pays + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	public void update_identifiant(int id_client, String id) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET identifiant = '" + id + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
	
	public void update_mot_de_passe(int id_client, String mdp) {
		try {
			Connexion laConnexion =  new Connexion();
			Connection co = laConnexion.CreateConnexion();
			Statement requete = co.createStatement();
			int res = requete.executeUpdate("UPDATE Client\n" + 
					"SET mot_de_passe = '" + mdp + "'\n" + 
					"WHERE id_client = " + id_client);
			co.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}

	}
}
