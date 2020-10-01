package Liste_Memoire;

public class ListeMemoireCommandeDAO {

	private static ListeMemoireCommandeDAO instance;

	private List<Commande> donnees;


	public static ListeMemoireCommandeDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireCommandeDAO();
		}

		return instance;
	}

	private ListeMemoireCommandeDAO() {

		this.donnees = new ArrayList<Commande>();
		LocalDate dd1 = LocalDate.of(2005, 02, 25);
		LocalDate df1 = LocalDate.of(2000, 4, 30);
		LocalDate dd2 = LocalDate.of(2001, 12, 10);
		LocalDate df2 = LocalDate.of(2001, 4, 15);
		this.donnees.add(new Commande());
		this.donnees.add(new Commande());
	}


	public boolean create(Commande objet) {

		objet.setId_commande(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_commande(objet.getId_commande() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	public boolean update(Commande objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'une categorie inexistante");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	public boolean delete(Commande objet) {

		Commande supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'une categorie inexistante");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	public Commande getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Commande());
		if (idx == -1) {
			throw new IllegalArgumentException("Aucune categorie ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}
	
	public ArrayList<Commande> getByDateCommande(LocalDate date_commande) {
		Iterator<Commande> it = donnees.iterator();
		ArrayList<Commande> list = null;
		while(it.hasNext()) {
			Commande e = it.next();
			if(e.getDate_commande()==date_commande) {
				list.add(e);
			}
		}
		return null;
	}
	
	public Commande getByIdClient(int id_client) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Commande());
		if (idx == -1) {
			throw new IllegalArgumentException("Aucune categorie ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<Commande> findAll() {
		return (ArrayList<Commande>) this.donnees;
	}

	public Commande getById(int id1, int id2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDAOFactory(Persistance mysql) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
