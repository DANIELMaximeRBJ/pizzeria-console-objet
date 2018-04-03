package fr.pizzeria.service;



import java.util.Scanner;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {


	public void executeUC(IPizzaDao dao, Scanner scanner) throws SavePizzaException 
	{
		LOG.info("\n Ajout d’une nouvelle pizza \n ");
		
 		
		LOG.info("\n Veuillez saisir le code : ");
 		repCode = questionUser.next();
 		LOG.info("\n Veuillez saisir le nom (sans espace) : ");
 		repLibelle = questionUser.next();
 		LOG.info("\n Veuillez saisir le prix : ");
 		repPrix = Double.parseDouble(questionUser.next()) ;
 		LOG.info("\n Veuillez saisir la catégorie de pizza: VIANDE, SANS_VIANDE, POISSON ");
 		repCP = questionUser.next();
 		
 		
	
 		if(dao.pizzaExists(repCode))
		{
			throw new SavePizzaException("code deja existant dans la liste");
		}
		if(repPrix < 0)
		{
			throw new SavePizzaException("Prix inférieur à zero");
		}
		if(repCP != null && dao != null)
 		{
 			CategoriePizza cp = CategoriePizza.valueOf(repCP);
 			dao.saveNewPizza(new Pizza(repCode,repLibelle,repPrix,cp));
 		}
 		
	}

}

