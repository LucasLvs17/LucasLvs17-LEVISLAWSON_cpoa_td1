package Main;
import java.util.Scanner;

import RequetesSQL.ReqCategorie;

public class Menu {
	
	
	public void menu_requete() {
		

		System.out.println("Bienvenue ! ");
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
			System.out.println("1 : Ajouter un abonnement");
			System.out.println("2 : Supprimer un abonnement");
			System.out.println("3 : Changer la date de d�but");
			System.out.println("4 : Changer la date de fin");
			
			
		}else if(choix1 == 2) {
			System.out.println("Choisir la manipulation");
			System.out.println("1 : Ajouter un client");
			System.out.println("2 : Supprimer un client");
			System.out.println("3 : Changer le nom");
			System.out.println("4 : Changer le pr�nom");
			System.out.println("4 : Changer le num�ro de rue");
			System.out.println("4 : Changer le code postal");
			System.out.println("4 : Changer la  voie");
			System.out.println("4 : Changer la ville");
			System.out.println("4 : Changer le pays");
		}else if(choix1 == 3) {
			System.out.println("Choisir la manipulation");
			System.out.println("1 : Ajouter une revue");
			System.out.println("2 : Supprimer une revue");
			System.out.println("3 : Changer la revue");
		}else if(choix1 == 4){
			System.out.println("Choisir la manipulation");
			System.out.println("1 : Ajouter une p�riodicit�");
			System.out.println("2 : Supprimer une p�riodicit�");
			System.out.println("3 : Changer la p�riodicit�");
		}else if(choix1 == 5){
			System.out.println("Choisir la manipulation");
			System.out.println("1 : Ajouter une p�riodicit�");
			System.out.println("2 : Supprimer une p�riodicit�");
			System.out.println("3 : Changer la p�riodicit�");
		}else{
			System.out.println("Choisir la manipulation");
			System.out.println("1 : Ajouter une p�riodicit�");
			System.out.println("2 : Supprimer une p�riodicit�");
			System.out.println("3 : Changer la p�riodicit�");
		}
		
		
		
		
		
		
	}

}