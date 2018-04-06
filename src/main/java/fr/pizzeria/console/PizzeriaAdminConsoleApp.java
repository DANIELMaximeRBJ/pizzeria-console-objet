package fr.pizzeria.console;
import fr.pizzeria.service.*;
import fr.pizzeria.exception.*;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.PizzaDB;


public class PizzeriaAdminConsoleApp extends PizzaDB {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public static void main(String[] args) {
		PizzaDB dao = new PizzaDB();
		@SuppressWarnings("resource")
		Scanner questionUser = new Scanner(System.in) ;
			
		menu();	
		MenuServiceFactory msf = new MenuServiceFactory();


	 	int rep = 0;
	 	
		while(rep != 99)
		{
			rep = questionUser.nextInt();
			
			if (rep == 99)
		 	{
				LOG.info("\n Aurevoir ☹\n");
				new AppService().executer("valeur 1");
				break;
		 	}
	 		try 
	 	 	{
	 			msf.getInstance(rep).executeUC(dao, new Scanner(System.in));
	 		} 
	 		catch (StockageException e)
	 		{
	 			LOG.info(e.getMessage());
	 		}
		 	
		 	menu();
		 		
		 	if 	(rep != 1 && rep != 2 && rep != 3 && rep != 4 && rep != 99)
		 	{
		 		LOG.info("\n retapper une valeur correct \n");
		 		menu();
		 	}
		}
		

	}
	
	public static void menu()
	{
		LOG.info("\n");
		LOG.info("***** Pizzeria Administration ***** \n");
		LOG.info("1. Lister les pizzas ");
		LOG.info("2. Ajouter une nouvelle pizza ");
		LOG.info("3. Mettre à jour une pizza");
		LOG.info("4. Supprimer une pizza");
		LOG.info("99. Sortir ");
		new AppService().executer("valeur 1");
	}

}
