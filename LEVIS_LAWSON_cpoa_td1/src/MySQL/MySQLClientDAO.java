package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.Connexion;
import POJO.Client;
import DAO.*;

public class MySQLClientDAO implements ClientDAO{

private static MySQLClientDAO instance;
	
	private MySQLClientDAO() {
		
	}
	
	
	
	public static MySQLClientDAO getInstance() {
		if (instance == null) {	
			instance = new MySQLClientDAO();
		}
		return instance;
	}
	
	

	public boolean create(Client c) {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("insert into CLIENT(id_client, nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) value (?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			requete.setInt(1, c.getId_client());
			requete.setString(2, c.getNom());
			requete.setString(3, c.getPrenom());
			requete.setString(4, c.getIdentifiant());
			requete.setString(5, c.getMot_de_passe());
			requete.setString(6, c.getAdr_numero());
			requete.setString(7, c.getAdr_voie());
			requete.setString(8, c.getAdr_code_postal());
			requete.setString(9, c.getAdr_ville());
			requete.setString(10, c.getAdr_pays());
			int nbLigne = requete.executeUpdate();
			// récupère l'id
			if(nbLigne > 0) {
				ResultSet key = requete.getGeneratedKeys();
				if(key.next()) {
					c.setId_client(key.getInt(1));
				}
			}
			laCo.close();
			return true;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return false;
		}
	}

	public boolean update(Client c) {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("update CLIENT set nom=?, prenom = ?, identifiant = ?, mot_de_passe = ?, adr_numero = ?, adr_voie = ?, adr_code_postal = ?, adr_ville = ?, adr_pays = ? WHERE id_client = ?");
			requete.setString(1, c.getNom());
			requete.setString(2, c.getPrenom());
			requete.setString(3, c.getIdentifiant());
			requete.setString(4, c.getMot_de_passe());
			requete.setString(5, c.getAdr_numero());
			requete.setString(6, c.getAdr_voie());
			requete.setString(7, c.getAdr_code_postal());
			requete.setString(8, c.getAdr_ville());
			requete.setString(9, c.getAdr_pays());
			requete.setInt(10, c.getId_client());
			requete.executeUpdate();
			laCo.close();
			return true;
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return false;
		}
	}

	public boolean delete(Client c) {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("DELETE FROM CLIENT WHERE id_client = ?");
			requete.setInt(1, c.getId_client());
			requete.executeUpdate();
			laCo.close();
			
			return true;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return false;
		}
	}

	public Client getById(int id) {
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM Client WHERE id_client = ?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			laCo.close();
			Client c = new Client();
			c.setId_client(id);
			if(res.next()) {
				c.setPrenom(res.getString("prenom"));
				c.setNom(res.getString("nom"));
				c.setAdr_numero(res.getString("adr_numero"));
				c.setAdr_voie(res.getString("adr_voie"));
				c.setAdr_ville(res.getString("adr_ville"));
				c.setAdr_pays(res.getString("adr_pays"));
			}
			return c;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Client> getByNomPrenom(String nom, String prenom){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM CLIENT WHERE nom = ? AND prenom = ?");
			requete.setString(1, nom);
			requete.setString(2, prenom);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Client> a = new ArrayList<Client>();
			Client c = new Client();
			while(res.next()) {
				c.setId_client(res.getInt("id_client"));
				c.setPrenom(res.getString("prenom"));
				c.setNom(res.getString("nom"));
				c.setAdr_numero(res.getString("adr_numero"));
				c.setAdr_voie(res.getString("adr_voie"));
				c.setAdr_ville(res.getString("adr_ville"));
				c.setAdr_pays(res.getString("adr_pays"));
				a.add(c);
			}
			return a;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	
	public ArrayList<Client> getByNoRue(int no){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM CLIENT WHERE adr_numero = ?");
			requete.setInt(1, no);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Client> a = new ArrayList<Client>();
			Client c = new Client();
			while(res.next()) {
				c.setId_client(res.getInt("id_client"));
				c.setPrenom(res.getString("prenom"));
				c.setNom(res.getString("nom"));
				c.setAdr_numero(res.getString("adr_numero"));
				c.setAdr_voie(res.getString("adr_voie"));
				c.setAdr_ville(res.getString("adr_ville"));
				c.setAdr_pays(res.getString("adr_pays"));
				a.add(c);
			}
			return a;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	
	public ArrayList<Client> getByVoie(String v){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM CLIENT WHERE adr_voie = ?");
			requete.setString(1, v);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Client> a = new ArrayList<Client>();
			Client c = new Client();
			while(res.next()) {
				c.setId_client(res.getInt("id_client"));
				c.setPrenom(res.getString("prenom"));
				c.setNom(res.getString("nom"));
				c.setAdr_numero(res.getString("adr_numero"));
				c.setAdr_voie(res.getString("adr_voie"));
				c.setAdr_ville(res.getString("adr_ville"));
				c.setAdr_pays(res.getString("adr_pays"));
				a.add(c);
			}
			return a;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	
	public ArrayList<Client> getByVille(String v){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM CLIENT WHERE adr_ville = ?");
			requete.setString(1, v);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Client> a = new ArrayList<Client>();
			Client c = new Client();
			while(res.next()) {
				c.setId_client(res.getInt("id_client"));
				c.setPrenom(res.getString("prenom"));
				c.setNom(res.getString("nom"));
				c.setAdr_numero(res.getString("adr_numero"));
				c.setAdr_voie(res.getString("adr_voie"));
				c.setAdr_ville(res.getString("adr_ville"));
				c.setAdr_pays(res.getString("adr_pays"));
				a.add(c);
			}
			return a;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}
	
	
	public ArrayList<Client> getByPays(String v){
		Connection laCo = Connexion.CreateConnexion();
		try {
			PreparedStatement requete = laCo.prepareStatement("SELECT * FROM CLIENT WHERE adr_pays = ?");
			requete.setString(1, v);
			ResultSet res = requete.executeQuery();
			laCo.close();
			ArrayList<Client> a = new ArrayList<Client>();
			Client c = new Client();
			while(res.next()) {
				c.setId_client(res.getInt("id_client"));
				c.setPrenom(res.getString("prenom"));
				c.setNom(res.getString("nom"));
				c.setAdr_numero(res.getString("adr_numero"));
				c.setAdr_voie(res.getString("adr_voie"));
				c.setAdr_ville(res.getString("adr_ville"));
				c.setAdr_pays(res.getString("adr_pays"));
				a.add(c);
			}
			return a;
			
		}catch(SQLException e){
			System.out.println("Pb select" + e.getMessage());
			return null;
		}
	}

	public Object getDAOFactory(Persistance mysql) {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}



	@Override
	public ArrayList<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Client getById(int id1, int id2) {
		// TODO Auto-generated method stub
		return null;
	}

}

