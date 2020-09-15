package DAO;

public interface DAO<T> {
	public abstract boolean create(T object);
	public abstract boolean update(T objet);
	public abstract boolean delete(T objet);

}
