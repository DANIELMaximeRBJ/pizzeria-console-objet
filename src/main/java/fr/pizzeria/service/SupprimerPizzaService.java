package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.IPizzaDao;

public class SupprimerPizzaService extends MenuService{


	public void executeUC(IPizzaDao dao, Scanner scanner) throws DeletePizzaException
	{
		LOG.info("\n Suppression d’une pizza \n");
 		
		LOG.info("\n Veuillez choisir le code de la pizza à supprimer \n");
 		repCode = questionUser.next();

 		if(!dao.pizzaExists(repCode))
		{
			throw new DeletePizzaException("code non existant dans la liste");
		}
 		dao.deletePizza(repCode);

 		
	}

}
