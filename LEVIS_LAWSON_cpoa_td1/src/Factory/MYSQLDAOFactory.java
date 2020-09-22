package Factory;

import DAO.*;
import Factory.DAOFactory;
import MySQL.MySQLCategorieDAO;

public class MYSQLDAOFactory extends DAOFactory{
	public CategorieDAO getCategorieDAO() {
		return MySQLCategorieDAO.getInstance();
	}

	public ClientDAO getClientDAO() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	public ProduitDAO getProduitDAO() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	public CommandeDAO getCommandeDAO() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

}
