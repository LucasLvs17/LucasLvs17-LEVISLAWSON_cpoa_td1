package POJO;


public class Categorie {

	private int id_categorie;
	private String titre;
	private String visuel;
	
	public Categorie(int id_categorie, String titre, String visuel) {
		this.setIdCategorie(id_categorie);
		this.setTitre(titre);
		this.setVisuel(visuel);
		
	}

	public int getIdCategorie() {
		return id_categorie;
	}

	public void setIdCategorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	
	public String toString() {
		return "(" + (this.id_categorie>=0?this.titre:"nouveau")+")" + this.id_categorie + this.titre + this.visuel;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		if (id_categorie != other.id_categorie)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (visuel == null) {
			if (other.visuel != null)
				return false;
		} else if (!visuel.equals(other.visuel))
			return false;
		return true;
	}
	
	
}
