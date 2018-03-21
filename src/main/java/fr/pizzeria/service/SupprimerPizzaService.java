package fr.pizzeria.service;

import fr.pizzeria.model.PizzaMemDao;

public class SupprimerPizzaService extends MenuService{


	public void executeUC(PizzaMemDao dao) 
	{
		System.out.println("\n Suppression d’une pizza \n");
 		
 		System.out.println("\n Veuillez choisir le code de la pizza à supprimer \n");
 		repCode = questionUser.next();
 		
 		dao.deletePizza(repCode);
	}

}
