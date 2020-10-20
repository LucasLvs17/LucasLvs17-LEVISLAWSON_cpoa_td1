package DAO;

import java.util.ArrayList;
import POJO.*;
import javafx.collections.ObservableList;

public interface ClientDAO extends DAO<Client>{
	
Object getDAOFactory(Persistance mysql);
	

	public abstract Client getById(int id);
	public ObservableList<Client> getAll();


	ObservableList<Client> OrderByNom();


	ObservableList<Client> getByNomPrenom(String nom, String prenom);


	ObservableList<Client> getByVille(String v);
}
