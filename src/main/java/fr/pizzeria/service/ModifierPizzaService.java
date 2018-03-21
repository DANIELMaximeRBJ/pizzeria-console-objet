package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;


public class ModifierPizzaService extends MenuService{


	public void executeUC(PizzaMemDao dao) {
		System.out.println("\n Mise à jour d’une pizza \n");
 		
 		System.out.println("\n Veuillez choisir le code de la pizza à modifier \n");
 		repNouvCode = questionUser.next();
 		
 		System.out.println("\n Veuillez saisir le nouveau code : ");
 		repCode = questionUser.next();
 		System.out.println("\n Veuillez saisir le nouveau nom (sans espace) : ");
 		repLibelle = questionUser.next();
 		System.out.println("\n Veuillez saisir le nouveau prix : ");
 		repPrix = Double.parseDouble(questionUser.next()) ;
 		
 		dao.updatePizza(repNouvCode, new Pizza(repCode,repLibelle,repPrix));
		
	}

}
