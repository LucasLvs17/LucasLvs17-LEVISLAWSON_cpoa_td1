package DAO;
import POJO.*;

public interface CommandeDAO extends DAO<Commande>{
	
	public abstract Commande getById(int id_commande);
}
