package Liste_Memoire;

import java.util.ArrayList;
import java.util.List;

import DAO.Persistance;
import POJO.Produit;

public class ListeMemoireProduitDAO {

	private static ListeMemoireProduitDAO instance;

	private List<Produit> donnees;


	public static ListeMemoireProduitDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireProduitDAO();
		}

		return instance;
	}

	private ListeMemoireProduitDAO() {

		this.donnees = new ArrayList<Produit>();

		this.donnees.add(new Produit());
		this.donnees.add(new Produit());
	}


	
	public boolean create(Produit objet) {

		objet.setId_produit(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_produit(objet.getId_produit() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	public boolean update(Produit objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'une categorie inexistante");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	public boolean delete(Produit objet) {

		Produit supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'une categorie inexistante");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	
	public Produit getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Produit());
		if (idx == -1) {
			throw new IllegalArgumentException("Aucune categorie ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<Produit> findAll() {
		return (ArrayList<Produit>) this.donnees;
	}

	
	public Produit getById(int id1, int id2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDAOFactory(Persistance mysql) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
