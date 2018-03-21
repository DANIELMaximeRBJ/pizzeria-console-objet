package fr.pizzeria.service;
import fr.pizzeria.model.PizzaMemDao;
public class ListerPizzasService extends MenuService {
	
	public void executeUC()
	{
		PizzaMemDao pizza = new PizzaMemDao();
		
 		System.out.println("\n Lister les pizzas \n");
 		
		for(int i=0; i < pizza.findAllPizzas().size() ; i++)
 		{
 			if(pizza.findAllPizzas().get(i) != null)
 			{
 				System.out.println(pizza.findAllPizzas().get(i).getCode() + "->" + pizza.findAllPizzas().get(i).getLibelle() + "(" +  pizza.findAllPizzas().get(i).getPrix() + "€)");
 			}	 			
 		}
	}
}
