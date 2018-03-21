package fr.pizzeria.service;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class AjouterPizzaService extends MenuService {
	
	public void executeUC(PizzaMemDao dao) throws SavePizzaException 
	{
		System.out.println("\n Ajout d’une nouvelle pizza \n ");
 		
 		System.out.println("\n Veuillez saisir le code : ");
 		repCode = questionUser.next();
 		System.out.println("\n Veuillez saisir le nom (sans espace) : ");
 		repLibelle = questionUser.next();
 		System.out.println("\n Veuillez saisir le prix : ");
 		repPrix = Double.parseDouble(questionUser.next()) ;
 		
 		if(dao.pizzaExists(repCode))
		{
			throw new SavePizzaException("code deja existant dans la liste");
		}
		if(repPrix < 0)
		{
			throw new SavePizzaException("Prix inférieur à zero");
		}
 	
 		dao.saveNewPizza(new Pizza(repCode,repLibelle,repPrix));
	}

}

