package DAO;
import java.util.ArrayList;

import POJO.*;

public interface CategorieDAO extends DAO<Categorie>{
	

	public abstract Categorie getById(int id1, int id2);

	ArrayList<Categorie> findAll();

	Categorie getById(int id);

}
