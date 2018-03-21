package fr.pizzeria.service;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;


public class ModifierPizzaService extends MenuService 
{


	public void executeUC(PizzaMemDao dao) throws UpdatePizzaException   {
		System.out.println("\n Mise à jour d’une pizza \n");
 		
 		System.out.println("\n Veuillez choisir le code de la pizza à modifier \n");
 		repNouvCode = questionUser.next();
 		
 		System.out.println("\n Veuillez saisir le nouveau code : ");
 		repCode = questionUser.next();
 		System.out.println("\n Veuillez saisir le nouveau nom (sans espace) : ");
 		repLibelle = questionUser.next();
 		System.out.println("\n Veuillez saisir le nouveau prix : ");
 		repPrix = Double.parseDouble(questionUser.next());
 		
 		if(!dao.pizzaExists(repNouvCode))
		{
			throw new UpdatePizzaException("code non existant dans la liste");
		}
 		if(dao.pizzaExists(repCode))
		{
			throw new UpdatePizzaException("code deja existant dans la liste");
		}
		if(repPrix < 0)
		{
			throw new UpdatePizzaException("Prix inférieur à zero");
		}
 		
 		
 		dao.updatePizza(repNouvCode, new Pizza(repCode,repLibelle,repPrix));
 		


		
	}

}
