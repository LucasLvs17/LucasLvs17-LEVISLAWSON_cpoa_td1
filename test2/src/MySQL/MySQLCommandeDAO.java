package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.*;
import application.Connexion;
import javafx.collections.ObservableList;
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
			requete.setDate(2,  java.sql.Date.valueOf(c.getDate_commande()));
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
			requete.setDate(1, java.sql.Date.valueOf(c.getDate_commande()));
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
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM COMMANDE WHERE id_commande = ?");
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

	
	public ObservableList<Commande> getByIdCommande(int id_commande){
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
			return (ObservableList<Commande>) a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}

	public ObservableList<Commande> getByDateDebut(LocalDate date_commande){
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
			return (ObservableList<Commande>) a;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}

	
	public ObservableList<Commande> getByIdClient(int id_client){
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
			return (ObservableList<Commande>) a;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}

	@Override
	public ObservableList getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList getEnCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList getByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList getAllByClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList getAllById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
