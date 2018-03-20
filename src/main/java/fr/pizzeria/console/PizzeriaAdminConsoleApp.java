package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		Pizza[] pizzaArray = new Pizza[100];
		pizzaArray[0] = new Pizza(0,"PEP","Pépéronie",12.50);
		pizzaArray[1] = new Pizza(1,"MAR","Margherita",14.00);
		pizzaArray[2] = new Pizza(2,"REIN","La Reine",11.50);
		pizzaArray[3] = new Pizza(3,"FRO","La 4 Fromages",12.00);
		pizzaArray[4] = new Pizza(4,"CAN","La cannibale",12.50);
		pizzaArray[5] = new Pizza(5,"SAV","La savoyarde",13.00);
		pizzaArray[6] = new Pizza(6,"ORI","L’orientale",13.50);
		pizzaArray[7] = new Pizza(7,"IND","L’indienne",14.00);
		
		
		menu();
		Scanner questionUser = new Scanner(System.in) ;
	 	int rep = 0, nbTab =0 ;
	 	String repCode = "", repLibelle = "", repNouvCode = "";
	 	double repPrix = 0.0;
	 	
		while(rep != 99)
		{
			rep = questionUser.nextInt();
		 	if (rep == 1)
		 	{
		 		System.out.println("\n Lister les pizzas \n");
		 		
		 		for(int i=0;i < (pizzaArray.length - 1); i++)
		 		{
		 			if(pizzaArray[i] != null)
		 			{
		 				System.out.println(pizzaArray[i].getCode() + "->" + pizzaArray[i].getLibelle() + "(" +  pizzaArray[i].getPrix() + "€)");
		 			}	 			
		 		}
		 		System.out.println("\n");
		 		menu();
		 	}
		 	if (rep== 2)
		 	{
		 		for(int i=0;i < (pizzaArray.length - 1); i++)
		 		{
		 			if(pizzaArray[i] != null)
		 			{
		 				nbTab ++;
		 			}	 			
		 		}
		 		
		 		System.out.println("\n Ajout d’une nouvelle pizza \n ");
		 		
		 		System.out.println("\n Veuillez saisir le code : ");
		 		repCode = questionUser.next();
		 		System.out.println("\n Veuillez saisir le nom (sans espace) : ");
		 		repLibelle = questionUser.next();
		 		System.out.println("\n Veuillez saisir le prix : ");
		 		repPrix = Double.parseDouble(questionUser.next()) ;
		 		
		 		nbTab ++;
		 		pizzaArray[nbTab] = new Pizza(nbTab,repCode,repLibelle,repPrix);
		 		
		 		
		 		
		 		
		 		menu();
		 	}
		 	if (rep == 3)
		 	{
		 		System.out.println("\n Mise à jour d’une pizza \n");
		 		
		 		System.out.println("\n Veuillez choisir le code de la pizza à modifier \n");
		 		repNouvCode = questionUser.next();
		 		
		 		System.out.println("\n Veuillez saisir le nouveau code : ");
		 		repCode = questionUser.next();
		 		System.out.println("\n Veuillez saisir le nouveau nom (sans espace) : ");
		 		repLibelle = questionUser.next();
		 		System.out.println("\n Veuillez saisir le nouveau prix : ");
		 		repPrix = Double.parseDouble(questionUser.next()) ;
		 		
		 		for(int i=0;i < (pizzaArray.length - 1); i++)
		 		{
		 			if(pizzaArray[i] != null)
		 			{
		 				if (pizzaArray[i].getCode().equals(repCode))
		 				{
		 					pizzaArray[i] = new Pizza(nbTab,repCode,repLibelle,repPrix);
		 				}
		 			}	 			
		 		}
		 		
		 		menu();
		 	}
		 	if (rep == 4)
		 	{
		 		System.out.println("\n Suppression d’une pizza \n");
		 		
		 		System.out.println("\n Veuillez choisir le code de la pizza à supprimer \n");
		 		repCode = questionUser.next();
		 		
		 		for(int i=0;i < (pizzaArray.length - 1); i++)
		 		{
		 			if(pizzaArray[i] != null)
		 			{
		 				if (pizzaArray[i].getCode().equals(repCode))
		 				{
			 				pizzaArray[i] = pizzaArray[i+1];
		 				}
		 			}	
	 				for(int j=0;j < (pizzaArray.length - 1); j++)
 			 		{
	 					pizzaArray[i] = pizzaArray[i+1];
 			 		}
		 		}
		 		
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
