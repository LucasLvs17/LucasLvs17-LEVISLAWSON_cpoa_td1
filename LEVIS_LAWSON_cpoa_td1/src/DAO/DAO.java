package DAO;

import POJO.Client;

public interface DAO<T> {
	public abstract T getById(int id) throws Exception; //jsp a quoi ça sert mais bon
	public abstract boolean create(T object) throws Exception;
	public abstract boolean update(T objet) throws Exception; 
	public abstract boolean delete(T objet) throws Exception;
	

}
