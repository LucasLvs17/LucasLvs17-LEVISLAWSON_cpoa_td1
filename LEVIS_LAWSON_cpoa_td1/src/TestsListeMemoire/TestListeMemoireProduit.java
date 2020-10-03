package TestsListeMemoire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Liste_Memoire.ListeMemoireProduitDAO;
import POJO.Produit;

public class TestListeMemoireProduit {
	
	private ListeMemoireProduitDAO instance = ListeMemoireProduitDAO.getInstance();
	private Produit a;
	
	@Before
	public void setUpBefore() {
		a = new Produit(1, "test", "test", 1, "test", 1);
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

		Produit CategBdd = instance.getById(idC, idR);
		assertNotNull(CategBdd);
		instance.delete(a);
	}
	
	@Test
	public void testUpdate() {
		instance.create(a);
		Produit newA = new Produit(1, "test", "test", 1, "test", 1);
		instance.update(newA);
		Produit BddCateg = instance.getById(newA.getId_produit());
		assertEquals(newA, BddCateg);
		instance.delete(a);
	}

}
