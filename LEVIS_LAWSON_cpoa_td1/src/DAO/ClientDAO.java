package DAO;
import java.util.ArrayList;

import POJO.*;

public interface ClientDAO extends DAO<Client>{

	Object getDAOFactory(Persistance mysql);
	


	ArrayList<Client> findAll();


	Client getById(int id1);



	Client getById(int id1, int id2);
}
