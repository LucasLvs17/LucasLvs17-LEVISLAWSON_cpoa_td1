package TestsListeMemoire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Liste_Memoire.ListeMemoireClientDAO;
import POJO.Client;

public class TestListeMemorieClient {
	
	private ListeMemoireClientDAO instance = ListeMemoireClientDAO.getInstance();
	private Client a;
	
	@Before
	public void setUpBefore() {
		a = new Client(1, "test", "test", "test", "test", "test", "test", "test", "test", "test");
	}
	
	@Test
	public void create() {
		boolean b = instance.create(a);
		assertTrue(b);
		
	}
	
	@Test
	public void delete() {
		boolean b = instance.delete(a);
		assertTrue(b);
	}
	
	@Test
	public void testGetById() {
		instance.create(a);
		int idR = 1;
		int idC = 2;

		Client CategBdd = instance.getById(idC, idR);
		assertNotNull(CategBdd);
		instance.delete(a);
	}
	
	@Test
	public void testUpdate() {
		instance.create(a);
		Client newC = new Client(1, "test", "test", "test", "test", "test", "test", "test", "test", "test");
		instance.update(newC);
		Client BddCateg = instance.getById(newC.getId_client());
		assertEquals(newC, BddCateg);
		instance.delete(a);
	}
	
	

}
