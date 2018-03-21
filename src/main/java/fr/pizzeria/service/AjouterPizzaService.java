package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;

public class AjouterPizzaService extends MenuService {
	
	public void executeUC(PizzaMemDao dao) 
	{
		System.out.println("\n Ajout d’une nouvelle pizza \n ");
 		
 		System.out.println("\n Veuillez saisir le code : ");
 		repCode = questionUser.next();
 		System.out.println("\n Veuillez saisir le nom (sans espace) : ");
 		repLibelle = questionUser.next();
 		System.out.println("\n Veuillez saisir le prix : ");
 		repPrix = Double.parseDouble(questionUser.next()) ;
 	
 		dao.saveNewPizza(new Pizza(repCode,repLibelle,repPrix));
	}

}
