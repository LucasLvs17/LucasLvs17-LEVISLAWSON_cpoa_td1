package application;
import java.sql.*;

public class Connexion {
	public static Connection CreateConnexion(){
		String url= "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/levis5u_cpoa";
		url += "?serverTimezone=Europe/Paris";
		String login = "levis5u_appli";
		String pwd = "31801108";
		Connection maConnexion = null;
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch(SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());		
		}
		return maConnexion;
	} 
}
