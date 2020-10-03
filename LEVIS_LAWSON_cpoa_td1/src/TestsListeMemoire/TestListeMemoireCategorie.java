package TestsListeMemoire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.*;

import Liste_Memoire.ListeMemoireCategorieDAO;
import POJO.Categorie;

public class TestListeMemoireCategorie {
	
	private ListeMemoireCategorieDAO instance = ListeMemoireCategorieDAO.getInstance();
	private Categorie a;
	
	@Before
	public void setUpBefore() {
		a = new Categorie(1, "test", "test");
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

		Categorie CategBdd = instance.getById(idC, idR);
		assertNotNull(CategBdd);
		instance.delete(a);
	}
	
	@Test
	public void testUpdate() {
		instance.create(a);
		Categorie newA = new Categorie(1, "test", "test");
		instance.update(newA);
		Categorie BddCateg = instance.getById(newA.getIdCategorie());
		assertEquals(newA, BddCateg);
		instance.delete(a);
	}
	
	

}
