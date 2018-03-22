package fr.pizzeria.console;
import fr.pizzeria.service.*;
import fr.pizzeria.exception.*;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;

public class PizzeriaAdminConsoleApp extends PizzaMemDao {
	
	public static void main(String[] args) {
		PizzaMemDao dao = new PizzaMemDao();
		@SuppressWarnings("resource")
		Scanner questionUser = new Scanner(System.in) ;
			
		menu();	
		MenuServiceFactory msf = new MenuServiceFactory();


	 	int rep = 0;
	 	
		while(rep != 99)
		{
			rep = questionUser.nextInt();
			
	 		try 
	 	 	{
	 			msf.getInstance(rep).executeUC(dao);
	 		} 
	 		catch (StockageException e)
	 		{
	 			System.out.println(e.getMessage());
	 		}
		 	
		 	menu();
		 		
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
		System.out.println("\n");
		System.out.println("***** Pizzeria Administration ***** \n");
		
		System.out.println("1. Lister les pizzas ");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir ");

		
		
	 			
	}

}
