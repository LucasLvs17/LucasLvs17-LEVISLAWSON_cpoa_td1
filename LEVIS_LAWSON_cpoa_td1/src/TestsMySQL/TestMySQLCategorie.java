package TestsMySQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import POJO.Categorie;
import MySQL.MySQLCategorieDAO;

public class TestMySQLCategorie {
	
	private MySQLCategorieDAO instance = MySQLCategorieDAO.getInstance();
	private Categorie c;
	
	@Before
	public void setUpBefore(){
		Categorie c = new Categorie(1, "test", "test.png");
	}
	
	@BeforeEach @Test	
	public void create() {
		instance.create(c);
	}
	
	@AfterEach @Test
	public void delete() {
		instance.delete(c);
	}

	@Test
	public void TestById() {
		int idC = c.getIdCategorie();
		Categorie CategBdd = instance.getById(idC);
		assertNotNull(CategBdd);
	}
	
	@Test
	public void testUpdate() {
		Categorie newC = new Categorie(1, "test", "test.png");
		instance.update(newC);
		Categorie BddCateg = instance.getById(newC.getIdCategorie());
		assertEquals(newC, BddCateg);
	}
	
	@Test
	public void testGetByIdCateg() {
		ArrayList<Categorie> cBdd = instance.getByIdCategorie(1);
		assertTrue(cBdd.contains(c));
	}
	
	@Test
	public void testGetByTitre() {
		ArrayList<Categorie> cBdd = instance.getByTitre("test");
		assertTrue(cBdd.contains(c));
	}
	
	@Test
	public void testFindAll() {
		ArrayList<Categorie> cBdd = instance.findAll();
		assertTrue(cBdd.contains(c));
	}

}
