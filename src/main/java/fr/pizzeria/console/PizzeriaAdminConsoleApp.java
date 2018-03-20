package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		menu();
		Scanner questionUser = new Scanner(System.in) ;
	 	int rep = 0  ;
	 	
		while(rep != 99)
		{
			rep =questionUser.nextInt();
		 	if (rep == 1)
		 	{
		 		System.out.println("\n Lister les pizzas \n");
		 		menu();
		 	}
		 	if (rep== 2)
		 	{
		 		System.out.println("\n Ajout d’une nouvelle pizza \n ");
		 		menu();
		 	}
		 	if (rep == 3)
		 	{
		 		System.out.println("\n Mise à jour d’une pizza \n");
		 		menu();
		 	}
		 	if (rep == 4)
		 	{
		 		System.out.println("\n Suppression d’une pizza \n");
		 		menu();
		 	}
		 	
		 	if 	(rep != 1 && rep != 2 && rep != 3 && rep != 4 && rep != 99)
		 	{
		 		System.out.println("\n retapper une valeur correct \n");
		 		menu();
		 	}
		}
		if (rep == 99)
	 	{
	 		System.out.println("\n Aurevoir ☹\n");
	 	}
	}
	
	public static void menu()
	{
		System.out.println("***** Pizeeria Administration ***** \n");
		
		System.out.println("1. Lister les pizzas ");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir ");
		
		
	 			
	}

}
