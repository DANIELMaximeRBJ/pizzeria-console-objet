package fr.pizzeria.console;
import fr.pizzeria.service.*;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;

public class PizzeriaAdminConsoleApp extends PizzaMemDao {
	
	public static void main(String[] args) {
		
/*		Pizza[] pizzaArray = new Pizza[100];
		pizzaArray[0] = new Pizza(0,"PEP","Pépéronie",12.50);
		pizzaArray[1] = new Pizza(1,"MAR","Margherita",14.00);
		pizzaArray[2] = new Pizza(2,"REIN","La Reine",11.50);
		pizzaArray[3] = new Pizza(3,"FRO","La 4 Fromages",12.00);
		pizzaArray[4] = new Pizza(4,"CAN","La cannibale",12.50);
		pizzaArray[5] = new Pizza(5,"SAV","La savoyarde",13.00);
		pizzaArray[6] = new Pizza(6,"ORI","L’orientale",13.50);
		pizzaArray[7] = new Pizza(7,"IND","L’indienne",14.00);*/
		
		
		ListerPizzasService lps = new ListerPizzasService();
		AjouterPizzaService aps = new AjouterPizzaService();
		ModifierPizzaService mps = new ModifierPizzaService();
		SupprimerPizzaService sps = new SupprimerPizzaService();
		
		PizzaMemDao dao = new PizzaMemDao();
		
		
		
    
		
		menu();
		Scanner questionUser = new Scanner(System.in) ;
	 	int rep = 0;

	 	
		while(rep != 99)
		{
			rep = questionUser.nextInt();
		 	if (rep == 1)
		 	{
		 		lps.executeUC(dao);
		 		menu();
		 	}
		 	if (rep== 2)
		 	{	 		
		 		aps.executeUC(dao);
		 		menu();
		 	}
		 	if (rep == 3)
		 	{
		 		mps.executeUC(dao);		 		
		 		menu();
		 	}
		 	if (rep == 4)
		 	{		 		
		 		sps.executeUC(dao);
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
		System.out.println("***** Pizzeria Administration ***** \n");
		
		System.out.println("1. Lister les pizzas ");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir ");
		
		
	 			
	}

}
