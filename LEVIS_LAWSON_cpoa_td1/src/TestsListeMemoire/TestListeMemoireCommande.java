package TestsListeMemoire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Liste_Memoire.ListeMemoireCommandeDAO;
import POJO.Commande;

public class TestListeMemoireCommande {

	private ListeMemoireCommandeDAO instance = ListeMemoireCommandeDAO.getInstance();
	private Commande a;
	
	@Before
	public void setUpBefore() {
		a = new Commande();
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

		Commande CategBdd = instance.getById(idC, idR);
		assertNotNull(CategBdd);
		instance.delete(a);
	}
	
	@Test
	public void testUpdate() {
		instance.create(a);
		Commande newC = new Commande();
		instance.update(newC);
		Commande BddCateg = instance.getById(newC.getId_commande());
		assertEquals(newC, BddCateg);
		instance.delete(a);
	}
	
	@Test
	public void testGetByDate() {
		instance.create(a);
		ArrayList<Commande> AboBdd = instance.getByDateCommande(LocalDate.of(1998, 02, 03));
		assertNotNull(AboBdd);
		instance.delete(a);
	}
	
}
