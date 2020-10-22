package DAO;
import java.time.LocalDate;

import POJO.*;
import javafx.collections.ObservableList;

public interface CommandeDAO extends DAO<Commande>{
	
	public abstract Commande getById(int id_commande);

	public abstract ObservableList getAll();

	public abstract ObservableList getEnCours();

	public abstract ObservableList getByDate(LocalDate date);

	public abstract ObservableList getAllByClient();

	public abstract ObservableList getAllById();
}
