package TestsMySQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MySQL.MySQLClientDAO;
import POJO.Client;

public class TestMySQLClient {

	private MySQLClientDAO instance = MySQLClientDAO.getInstance();
	private Client c;
	
	@Before
	public void setUpBefore(){
		Client c = new Client(1, "Jean", "Michel", "test", "test", "test", "test", "test", "test", "test");
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
		int idC = c.getId_client();
		Client CategBdd = instance.getById(idC);
		assertNotNull(CategBdd);
	}
	
	@Test
	public void testUpdate() {
		Client newC = new Client(1, "test", "test.png", "test", "test", "test", "test", "test", "test", "test");
		instance.update(newC);
		Client BddCateg = instance.getById(newC.getId_client());
		assertEquals(newC, BddCateg);
	}
	
	/*@Test
	public void testGetByIdClient() {
		ArrayList<Client> cBdd = instance.getById(1, 2);
		assertTrue(cBdd.contains(c));
	}*/
	
	@Test
	public void testGetByNomPrenom() {
		ArrayList<Client> cBdd = instance.getByNomPrenom("Jean", "Michel");
		assertTrue(cBdd.contains(c));
	}
	
	@Test
	public void testGetByNoRue() {
		ArrayList<Client> cBdd = instance.getByNoRue(1);
		assertTrue(cBdd.contains(c));
	}
	
	@Test
	public void testGetByNoVoie() {
		ArrayList<Client> cBdd = instance.getByVoie("test");
		assertTrue(cBdd.contains(c));
	}
	
	@Test
	public void testGetByVille() {
		ArrayList<Client> cBdd = instance.getByVille("test");
		assertTrue(cBdd.contains(c));
	}
	
	@Test
	public void testGetByPays() {
		ArrayList<Client> cBdd = instance.getByPays("test");
		assertTrue(cBdd.contains(c));
	}
	
	@Test
	public void testFindAll() {
		ArrayList<Client> cBdd = instance.findAll();
		assertTrue(cBdd.contains(c));
	}
	
}
