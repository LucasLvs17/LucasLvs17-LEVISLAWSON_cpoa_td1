package Liste_Memoire;
import java.util.ArrayList;
import java.util.List;

import DAO.CategorieDAO;
import POJO.Categorie;

public class ListeMemoireCategorieDAO implements CategorieDAO{

	private static ListeMemoireCategorieDAO instance;

	private List<Categorie> donnees;


	public static ListeMemoireCategorieDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireCategorieDAO();
		}

		return instance;
	}

	private ListeMemoireCategorieDAO() {

		this.donnees = new ArrayList<Categorie>();

		this.donnees.add(new Categorie(1, "Pulls", "pulls.png"));
		this.donnees.add(new Categorie(2, "Bonnets", "bonnets.png"));
	}


	@Override
	public boolean create(Categorie objet) {

		objet.setIdCategorie(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setIdCategorie(objet.getIdCategorie() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Categorie objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'une categorie inexistante");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(Categorie objet) {

		Categorie supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'une categorie inexistante");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public Categorie getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Categorie(id, "test", "test.png"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucune categorie ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Categorie> findAll() {
		return (ArrayList<Categorie>) this.donnees;
	}

	@Override
	public Categorie getById(int id1, int id2) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
