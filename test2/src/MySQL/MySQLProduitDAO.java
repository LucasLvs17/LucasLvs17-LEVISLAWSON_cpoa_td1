package MySQL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Connexion;
import POJO.Produit;

public class MySQLProduitDAO {

private static MySQLProduitDAO instance;
	
	public static MySQLProduitDAO getInstance() {
		if(instance==null) {
			instance = new MySQLProduitDAO();
		}
		return instance;
	}

	public boolean create(Produit c) throws Exception {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("insert into PRODUIT(id_produit, nom, description, tarif, visuel, id_categorie) value (?,?,?,?,?,?)");
			requete.setInt(1,  c.getId_produit());
			requete.setString(2, c.getNom());
			requete.setString(3,  c.getDescription());
			requete.setDouble(4, c.getTarif());
			requete.setString(5, c.getVisuel());
			requete.setInt(6, c.getId_categorie());
			int nbLigne = requete.executeUpdate();
			
			if (nbLigne > 0){
				ResultSet key = requete.getGeneratedKeys();
				if(key.next()) {
					c.setId_produit(key.getInt(1));
				}
			}
		laCo.close();
		return true;
	}catch(SQLException e) {
		System.out.println("Pb select" + e.getMessage());
		return false;
	}
		
}
	
	public boolean update(Produit c) throws Exception {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("update PRODUIT nom = ?, description= ?, tarif = ?, visuel = ?, id_categorie = ? WHERE id_produit = ?");
			requete.setString(1, c.getNom());
			requete.setString(2,  c.getDescription());
			requete.setDouble(3, c.getTarif());
			requete.setString(4, c.getVisuel());
			requete.setInt(5, c.getId_categorie());
			requete.executeUpdate();
			laCo.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Pb select" + e.getMessage());
			return false;
		}
	}
	
	
	public boolean delete(Produit c) throws Exception {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("DELETE FROM PRODUIT WHERE id_produit = ?");
			requete.setInt(1, c.getId_produit());
			requete.executeUpdate();
			laCo.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Pb select" + e.getMessage());
			return false;
		}
	}
	
	
	public Produit getById(int id_produit) {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM PRODUIT WHERE id_produit = ?");
			requete.setInt(1, id_produit);
			ResultSet res = requete.executeQuery();
			laCo.close();
			Produit c = new Produit();
			c.setId_produit(id_produit);
			if(res.next()) {
				c.setDescription(res.getString("description"));
				c.setTarif(res.getDouble("tarif"));
				c.setVisuel(res.getString("visuel"));
				c.setId_categorie(res.getInt("id_categorie"));
			}
			return c;
		}catch(SQLException e) {
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Produit> getByIdProduit(int id_produit){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM PRODUIT WHERE id_produit = ?");
			requete.setInt(1, id_produit);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Produit> a = new ArrayList<Produit>();
			Produit c = new Produit();
			while(res.next()) {
				c.setId_produit(res.getInt("id_produit"));
				c.setNom(res.getString("nom"));
				c.setDescription(res.getString("description"));
				c.setTarif(res.getDouble("tarif"));
				c.setVisuel(res.getString("visuel"));
				c.setId_categorie(res.getInt("id_categorie"));
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Produit> getByNom(String nom){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM PRODUIT WHERE nom = ?");
			requete.setString(1, nom);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Produit> a = new ArrayList<Produit>();
			Produit c = new Produit();
			while(res.next()) {
				c.setNom(res.getString("nom"));
				c.setDescription(res.getString("description"));
				c.setTarif(res.getDouble("tarif"));
				c.setVisuel(res.getString("visuel"));
				c.setId_categorie(res.getInt("id_categorie"));
				c.setId_produit(res.getInt("id_produit"));
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Produit> getByIdDescription(String description){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM PRODUIT WHERE description = ?");
			requete.setString(1, description);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Produit> a = new ArrayList<Produit>();
			Produit c = new Produit();
			while(res.next()) {
				c.setDescription(res.getString("description"));
				c.setTarif(res.getDouble("tarif"));
				c.setVisuel(res.getString("visuel"));
				c.setId_categorie(res.getInt("id_categorie"));
				c.setId_produit(res.getInt("id_produit"));
				c.setNom(res.getString("nom"));
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Produit> getByIdTarif(Double tarif){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM PRODUIT WHERE tarif = ?");
			requete.setDouble(1, tarif);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Produit> a = new ArrayList<Produit>();
			Produit c = new Produit();
			while(res.next()) {
				c.setTarif(res.getDouble("tarif"));
				c.setVisuel(res.getString("visuel"));
				c.setId_categorie(res.getInt("id_categorie"));
				c.setId_produit(res.getInt("id_produit"));
				c.setNom(res.getString("nom"));
				c.setDescription(res.getString("description"));
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Produit> getByIdVisuel(String visuel){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM PRODUIT WHERE visuel = ?");
			requete.setString(1, visuel);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Produit> a = new ArrayList<Produit>();
			Produit c = new Produit();
			while(res.next()) {
				c.setVisuel(res.getString("visuel"));
				c.setId_categorie(res.getInt("id_categorie"));
				c.setId_produit(res.getInt("id_produit"));
				c.setNom(res.getString("nom"));
				c.setDescription(res.getString("description"));
				c.setTarif(res.getDouble("tarif"));
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Produit> getByIdCategorie(int id_categorie){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM PRODUIT WHERE id_categorie = ?");
			requete.setInt(1, id_categorie);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Produit> a = new ArrayList<Produit>();
			Produit c = new Produit();
			while(res.next()) {
				c.setId_categorie(res.getInt("id_categorie"));
				c.setId_produit(res.getInt("id_produit"));
				c.setNom(res.getString("nom"));
				c.setDescription(res.getString("description"));
				c.setTarif(res.getDouble("tarif"));
				c.setVisuel(res.getString("visuel"));
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	
}
