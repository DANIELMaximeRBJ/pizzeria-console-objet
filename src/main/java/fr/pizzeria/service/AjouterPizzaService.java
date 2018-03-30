package fr.pizzeria.service;



import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class AjouterPizzaService extends MenuService {


	public void executeUC(PizzaMemDao dao) throws SavePizzaException 
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
 		CategoriePizza cp = CategoriePizza.valueOf(repCP);
	
 		if(dao.pizzaExists(repCode))
		{
			throw new SavePizzaException("code deja existant dans la liste");
		}
		if(repPrix < 0)
		{
			throw new SavePizzaException("Prix inférieur à zero");
		}
 	
 		dao.saveNewPizza(new Pizza(repCode,repLibelle,repPrix,cp));
	}

}

