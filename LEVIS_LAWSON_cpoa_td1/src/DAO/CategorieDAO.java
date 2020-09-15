package DAO;
import POJO.*;

public interface CategorieDAO extends DAO<Categorie>{
	public abstract Categorie getById(int id1, int id2);

}
