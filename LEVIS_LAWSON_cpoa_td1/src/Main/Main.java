package Main;

import DAO.Persistance;
import MySQL.MySQLCategorieDAO;
import POJO.*;
import java.util.Locale;

//import java.util.Scanner;

//import RequetesSQL.ReqCategorie;

public class Main {
	
	MySQLCategorieDAO c = MySQLCategorieDAO.getInstance();
	Categorie Cl = new Categorie(1, "TOUBA", "Manon");
	
	/*public void switchPersistance() {
		//partie persistance
		if(local_mode.isSelected()) {
			System.out.println("Mode local activ�");	
			p = Persistance.LISTE_MEMOIRE;
		}else {
			System.out.println("Mode local d�sactiv�");
			p = Persistance.MYSQL;
		}
	}*/
	
/*public void menu_requete() {
		

		/*System.out.println("Bienvenue ! ");
		Scanner sc = new Scanner(System.in);
		int choix1, choix2;
		boolean continuer = true;
		
		do {
			System.out.println("Choisir la table sur laquelle travailler");
			System.out.println("1 : ");
			System.out.println("2 : Categorie");
			System.out.println("3 : Client");
			System.out.println("4 : Commande");
			System.out.println("5 : Ligne_commande");
			System.out.println("6 : Produit");
			choix1 = sc.nextInt();
		}while(choix1 > 4);
		
		if(choix1 == 1) {
			ReqCategorie req = new ReqCategorie();
			System.out.println("Choisir la manipulation");
			System.out.println("1 : Ajouter une cat�gorie");
			System.out.println("2 : Supprimer une cat�gorie");
			System.out.println("3 : Changer le titre d'une cat�gorie");
			System.out.println("4 : Changer le visuel");
			
			
		}*/
}//}
