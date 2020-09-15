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
	
	public static ArrayList<Categories> getAllCategorie() throws ClassNotFoundException, SQLException {
    Connection conn=DBConnection.getDBConnection().getConnection();
    Statement stm;
    stm = conn.createStatement();
    String sql = "Select * From Categorie";
    ResultSet rst;
    rst = stm.executeQuery(sql);
    ArrayList<Categories> CategorieList = new ArrayList<>();
    while (rst.next()) {
        Categories categorie = new Categories(rst.getString("id_categorie"), rst.getString("titre"), rst.getString("visuel")"));
        CategorieList.add(categorie);
    }
    return CategorieList;
}
	
}
