package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.*;
import Main.Connexion;
import POJO.Commande;

public class MySQLCommandeDAO implements CommandeDAO{
	
	private static MySQLCommandeDAO instance;
	
	public static MySQLCommandeDAO getInstance() {
		if(instance==null) {
			instance = new MySQLCommandeDAO();
		}
		return instance;
	}

	@Override
	public boolean create(Commande c) throws Exception {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("insert into COMMANDE(id_commande, date_commande, id_client) value (?,?,?)");
			requete.setInt(1,  c.getId_commande());
			requete.setDate(2,  c.getDate_commande());
			requete.setInt(3, c.getId_client());
			int nbLigne = requete.executeUpdate();
			
			if (nbLigne > 0){
				ResultSet key = requete.getGeneratedKeys();
				if(key.next()) {
					c.setId_commande(key.getInt(1));
				}
			}
		laCo.close();
		return true;
	}catch(SQLException e) {
		System.out.println("Pb select" + e.getMessage());
		return false;
	}
		
}

	@Override
	public boolean update(Commande c) throws Exception {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("update COMMANDE date_commande = ?, id_client = ? WHERE id_commande = ?");
			requete.setDate(1, c.getDate_commande());
			requete.setInt(2, c.getId_client());
			requete.executeUpdate();
			laCo.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Pb select" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Commande c) throws Exception {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("DELETE FROM COMMANDE WHERE id_commande = ?");
			requete.setInt(1, c.getId_commande());
			requete.executeUpdate();
			laCo.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Pb select" + e.getMessage());
			return false;
		}
	}

	@Override
	public Commande getById(int id_commande) {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM COMMANDE WHERE if_commande = ?");
			requete.setInt(1, id_commande);
			ResultSet res = requete.executeQuery();
			laCo.close();
			Commande c = new Commande();
			c.setId_commande(id_commande);
			if(res.next()) {
				c.setDate_commande(res.getDate("date_commande").toLocalDate());
				c.setId_client(res.getInt("id_client"));
			}
			return c;
		}catch(SQLException e) {
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}

	
	public ArrayList<Commande> getByIdCommande(int id_commande){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM COMMANDE WHERE id_commande = ?");
			requete.setInt(1, id_commande);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Commande> a = new ArrayList<Commande>();
			Commande c = new Commande();
			while(res.next()) {
				c.setId_commande(res.getInt("id_commande"));
				c.setDate_commande(res.getDate("date_commande").toLocalDate());
				c.setId_client(res.getInt("id_client"));
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}

	public ArrayList<Commande> getByDateDebut(LocalDate date_commande){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM Abonnement WHERE date_debut = ?");
			requete.setDate(1, java.sql.Date.valueOf(date_commande));
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Commande> a = new ArrayList<Commande>();
			Commande c = new Commande();
			while(res.next()) {
				c.setDate_commande(res.getDate("date_debut").toLocalDate());
				c.setId_client(res.getInt("id_client"));
				c.setId_commande(res.getInt("id_commande"));
				a.add(c);
			}
			return a;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}

	
	public ArrayList<Commande> getByIdClient(int id_client){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM COMMANDE WHERE id_commande = ?");
			requete.setInt(1, id_client);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Commande> a = new ArrayList<Commande>();
			Commande c = new Commande();
			while(res.next()) {
				c.setId_client(res.getInt("id_client"));
				c.setId_commande(res.getInt("id_commande"));
				c.setDate_commande(res.getDate("date_commande").toLocalDate());
				a.add(c);
			}
			return a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	
}
