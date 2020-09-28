package Liste_Memoire;

import java.util.ArrayList;
import java.util.List;

import DAO.ClientDAO;
import DAO.Persistance;
import POJO.Client;

public  class ListeMemoireClientDAO implements ClientDAO{

	private static ListeMemoireClientDAO instance;

	private List<Client> donnees;


	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}

	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<Client>();

		this.donnees.add(new Client(1, "test", "test", "tst", "mdp", "10", "test", "testl", "test", "test"));
		this.donnees.add(new Client(2, "test2", "test2", "tst2", "mdp2", "101", "test2", "testl2", "test2", "test2"));
	}


	@Override
	public boolean create(Client objet) {

		objet.setId_client(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_client(objet.getId_client() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Client objet) {
		
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
	public boolean delete(Client objet) {

		Client supprime;
		
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
	public Client getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Client(id, "nom", "prenom", "identifiant", "mot_de_passe", "adr_numero", "adr_voie", "adr_code_postal", "adr_ville", "adr_pays"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucune categorie ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Client> findAll() {
		return (ArrayList<Client>) this.donnees;
	}

	@Override
	public Client getById(int id1, int id2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDAOFactory(Persistance mysql) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
