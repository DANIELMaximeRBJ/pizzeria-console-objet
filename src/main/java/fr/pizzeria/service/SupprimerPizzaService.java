package fr.pizzeria.service;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.PizzaMemDao;

public class SupprimerPizzaService extends MenuService{


	public void executeUC(PizzaMemDao dao) throws DeletePizzaException
	{
		System.out.println("\n Suppression d’une pizza \n");
 		
 		System.out.println("\n Veuillez choisir le code de la pizza à supprimer \n");
 		repCode = questionUser.next();

 		if(!dao.pizzaExists(repCode))
		{
			throw new DeletePizzaException("code non existant dans la liste");
		}
 		dao.deletePizza(repCode);

 		
	}

}
