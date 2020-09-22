package Factory;

import DAO.*;

public abstract class DAOFactory {
public static DAOFactory getDAOfactory(Persistance cible) {
		
		DAOFactory daoF = null;
		
		switch(cible) {
		case MYSQL:
			daoF = new MYSQLDAOFactory();
			break;
		case LISTE_MEMOIRE:
			daoF = new LISTEMEMOIREDAOFactory();
			break;
		}
		return daoF;
	}
	
	public abstract CategorieDAO getCategorieDAO();
	public abstract ClientDAO getClientDAO();
	public abstract CommandeDAO getCommandeDAO();
	public abstract ProduitDAO getProduitDAO();

}
