package fr.pizzeria.model;

import java.util.ArrayList;

import java.util.List;


public class PizzaMemDao implements IPizzaDao{
	private List<Pizza> liste = new ArrayList<>();
	public int nbTab=0;

	public PizzaMemDao(){
		liste.add(new Pizza(0,"PEP","Pépéronie",12.50));
		liste.add(new Pizza(1,"MAR","Margherita",14.00));
		liste.add(new Pizza(2,"REIN","La Reine",11.50));
		liste.add(new Pizza(3,"FRO","La 4 Fromages",12.00));
		liste.add(new Pizza(4,"CAN","La cannibale",12.50));
		liste.add(new Pizza(5,"SAV","La savoyarde",13.00));
		liste.add(new Pizza(6,"ORI","L’orientale",13.50));
		liste.add(new Pizza(7,"IND","L’indienne",14.00));	

	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return liste;
	}

	@Override
public void saveNewPizza(Pizza pizza) 
	{
		for(int i=0;i < liste.size(); i++)
 		{
 			nbTab ++;	 			
 		}
		if(nbTab != 0)
 		{
	 		nbTab ++;	
 		}
 		liste.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
 					nbTab --;
 					
	 				liste.remove(findPizzaByCode(codePizza));
	 				liste.add(pizza);	
	 				
	}

	@Override
	public void deletePizza(String codePizza) 
	{
	 	liste.remove(findPizzaByCode(codePizza));
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for(int i=0;i < liste.size(); i++)
 		{
 			if(pizzaExists(codePizza))
 			{
 				if (liste.get(i).getCode().equals(codePizza))
 				{
 					return liste.get(i);
 				}
 			}	
 		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
//		for(int i=0;i < liste.size(); i++)
// 		{
// 			if(liste.get(i) != null)
// 			{
// 				if (liste.get(i).getCode().equals(codePizza))
// 				{
// 					return true;
// 				}
// 			}	
// 		}
		return findPizzaByCode(codePizza)!=null;
	}
	
	
}
