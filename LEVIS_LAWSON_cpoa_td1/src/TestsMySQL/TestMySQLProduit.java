package TestsMySQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MySQL.MySQLProduitDAO;
import POJO.Produit;

public class TestMySQLProduit {
	
	private MySQLProduitDAO instance = MySQLProduitDAO.getInstance();
	private Produit p;
	
	@Before
	public void setUpBefore(){
		Produit p = new Produit(1, "test", "test", 10.5, "wow", 2);
	}
	
	@BeforeEach @Test	
	public void create() throws Exception {
		instance.create(p);
	}
	
	@AfterEach @Test
	public void delete() throws Exception {
		instance.delete(p);
	}

	@Test
	public void TestById() {
		int idP = p.getId_produit();
		Produit ProdBdd = instance.getById(idP);
		assertNotNull(ProdBdd);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Produit newP = new Produit(1, "test", "test.png", 10.5, "wow", 2);
		instance.update(newP);
		Produit BddProd = instance.getById(newP.getId_produit());
		assertEquals(newP, BddProd);
	}
	
	@Test
	public void testGetByIdProd() {
		ArrayList<Produit> pBdd = instance.getByIdProduit(1);
		assertTrue(pBdd.contains(p));
	}
	
	@Test
	public void testGetByNom() {
		ArrayList<Produit> pBdd = instance.getByNom("test");
		assertTrue(pBdd.contains(p));
	}
	
	@Test
	public void testGetByDesc() {
		ArrayList<Produit> pBdd = instance.getByIdDescription("test");
		assertTrue(pBdd.contains(p));
	}
	
	@Test
	public void testGetByPrix() {
		ArrayList<Produit> pBdd = instance.getByIdTarif(10.5);
		assertTrue(pBdd.contains(p));
	} //voir si on peut pas récup le double avec un test sur les nombres
	
	@Test
	public void testGetByVisuel() {
		ArrayList<Produit> pBdd = instance.getByIdVisuel("wow");
		assertTrue(pBdd.contains(p));
	}
	
	@Test
	public void testGetByIdCateg() {
		ArrayList<Produit> pBdd = instance.getByIdCategorie(1);
		assertTrue(pBdd.contains(p));
	}

}
