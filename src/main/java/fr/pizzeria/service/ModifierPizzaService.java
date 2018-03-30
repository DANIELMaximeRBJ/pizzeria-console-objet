package fr.pizzeria.service;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.utils.Validator;


public class ModifierPizzaService extends MenuService 
{

	public void executeUC(PizzaMemDao dao) throws StockageException   {
		LOG.info("\n Mise à jour d’une pizza \n");
 		
		LOG.info("\n Veuillez choisir le code de la pizza à modifier \n");
 		repNouvCode = questionUser.next();
 		
 		LOG.info("\n Veuillez saisir le nouveau code : ");
 		repCode = questionUser.next();
 		LOG.info("\n Veuillez saisir le nouveau nom (sans espace) : ");
 		repLibelle = questionUser.next();
 		LOG.info("\n Veuillez saisir le nouveau prix : ");
 		repPrix = Double.parseDouble(questionUser.next());
 		LOG.info("\n Veuillez saisir la catégorie de pizza: VIANDE, SANS_VIANDE, POISSON ");
 		repCP = questionUser.next();
 		
 		
 		if(!dao.pizzaExists(repNouvCode))
		{
			throw new UpdatePizzaException("code non existant dans la liste");
		}
 		

 		Validator.check(dao);
 		
		
 		
 		
 		dao.updatePizza(repNouvCode, new Pizza(repCode,repLibelle,repPrix,CategoriePizza.valueOf(repCP)));
 		


		
	}

}
