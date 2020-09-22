package MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.*;
import Main.Connexion;
import POJO.*;


public class MySQLCategorieDAO implements CategorieDAO{

	private static MySQLCategorieDAO instance;
	private ArrayList<Categorie> donnees;
	
private MySQLCategorieDAO() {
		//y a rien dedans
	}
	
public static MySQLCategorieDAO getInstance() {
	if (instance == null) {	
		instance = new MySQLCategorieDAO();
	}
	return instance;
}

@Override
public boolean create(Categorie a) {
	Connection laCo = Connexion.CreateConnexion();
	try {
		PreparedStatement requete = laCo.prepareStatement("insert into Categorie(id_categorie, titre, visuel) value (?,?,?)");
		requete.setInt(1, a.getIdCategorie());
		requete.setString(2, a.getTitre());
		requete.setString(3, a.getVisuel());
		requete.executeUpdate();
		laCo.close();
		return true;
	}catch(SQLException e){
		System.out.println("Pb select" + e.getMessage());
		return false;
	}
}

@Override
public boolean update(Categorie a) {
	Connection laCo = Connexion.CreateConnexion();
	try {
		PreparedStatement requete = laCo.prepareStatement("update Categorie(WHERE id_Categorie = ? AND titre = ? AND visuel = ?");
		requete.setInt(1, a.getIdCategorie());
		requete.setString(2, a.getTitre());
		requete.setString(3, a.getVisuel());
		requete.executeUpdate();
		laCo.close();
		return true;
	}catch(SQLException e){
		System.out.println("Pb select" + e.getMessage());
		return false;
	}
}

@Override
public boolean delete(Categorie a) {
	Connection laCo = Connexion.CreateConnexion();
	try {
		PreparedStatement requete = laCo.prepareStatement("DELETE FROM Categorie WHERE id_Categorie = ? and titre = ? AND visuel = ?");
		requete.setInt(2, a.getIdCategorie());
		requete.setString(1, a.getTitre());
		requete.setString(3, a.getVisuel());
		requete.executeUpdate();
		laCo.close();
		
		return true;
		
	}catch(SQLException e){
		System.out.println("Pb select" + e.getMessage());
		return false;
	}
}


@Override
public Categorie getById(int idC) {
	Connection laCo = Connexion.CreateConnexion();
	try {
		PreparedStatement requete = laCo.prepareStatement("SELECT * FROM Produit WHERE id_produit = ? AND id_categorie = ?");
		requete.setInt(2, idC);
		ResultSet res = requete.executeQuery();
		laCo.close();
		Categorie r = new Categorie();
		if(res.next()) {
			r.setIdCategorie(res.getInt("id_categorie"));
		}
		return r;
		
	}catch(SQLException e){
		System.out.println("Pb select" + e.getMessage());
		return null;
	}
}

public ArrayList<Categorie> getByIdCategorie(int idC) {
	Connection laCo = Connexion.CreateConnexion();
	try {
		PreparedStatement requete = laCo.prepareStatement("SELECT * FROM Produit WHERE id_categorie = ?");
		requete.setInt(1, idC);
		ResultSet res = requete.executeQuery();
		laCo.close();
		ArrayList<Categorie> a = new ArrayList<Categorie>();
		Categorie r = new Categorie();
		while(res.next()) {
			r.setIdCategorie(res.getInt("id_categorie"));
			r.setTitre(res.getString("titre"));
			r.setVisuel(res.getString("visuel"));
			a.add(r);
		}
		return a;
		
	}catch(SQLException e){
		System.out.println("Pb select" + e.getMessage());
		return null;
	}
	
}

public ArrayList<Categorie> getByTitre(String titre) {
	Connection laCo = Connexion.CreateConnexion();
	try {
		PreparedStatement requete = laCo.prepareStatement("SELECT * FROM Produit WHERE id_produit = ?");
		requete.setString(1, titre);
		ResultSet res = requete.executeQuery();
		laCo.close();
		ArrayList<Categorie> a = new ArrayList<Categorie>();
		Categorie r = new Categorie();
		while(res.next()) {
			r.setIdCategorie(res.getInt("id_categorie"));
			r.setTitre(res.getString("titre"));
			r.setVisuel(res.getString("visuel"));
			a.add(r);
		}
		return a;
		
	}catch(SQLException e){
		System.out.println("Pb select" + e.getMessage());
		return null;
	}
	
}

public ArrayList<Categorie> getByVisuel(String visuel) {
	Connection laCo = Connexion.CreateConnexion();
	try {
		PreparedStatement requete = laCo.prepareStatement("SELECT * FROM Revue WHERE id_revue = ?");
		requete.setString(1, visuel);
		ResultSet res = requete.executeQuery();
		laCo.close();
		ArrayList<Categorie> a = new ArrayList<Categorie>();
		Categorie r = new Categorie();
		while(res.next()) {
			r.setIdCategorie(res.getInt("id_categorie"));
			r.setTitre(res.getString("titre"));
			r.setVisuel(res.getString("visuel"));
			a.add(r);
		}
		return a;
		
	}catch(SQLException e){
		System.out.println("Pb select" + e.getMessage());
		return null;
	}
	
}

//jui pas sur de ça mais bon y a pas d'erreurs donc ça passe
@Override
public Categorie getById(int id1, int id2) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<Categorie> findAll() {
	return (ArrayList<Categorie>) this.donnees;
}





}






