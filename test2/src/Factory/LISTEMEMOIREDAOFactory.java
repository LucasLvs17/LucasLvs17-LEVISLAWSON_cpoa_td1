package Factory;
import DAO.*;
import Liste_Memoire.ListeMemoireCategorieDAO;

public class LISTEMEMOIREDAOFactory extends DAOFactory{

	@Override
	public CategorieDAO getCategorieDAO() {
		return ListeMemoireCategorieDAO.getInstance();
	}

	/*@Override
	public ClientDAO getClientDAO() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}*/

	@Override
	public ProduitDAO getProduitDAO() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	/*@Override
	public CommandeDAO getCommandeDAO() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}*/
	
}

