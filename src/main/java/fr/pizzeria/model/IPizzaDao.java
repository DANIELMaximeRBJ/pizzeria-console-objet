package fr.pizzeria.model;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public interface IPizzaDao {
	List<Pizza>findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	void deletePizza(String codePizza) throws DeletePizzaException;
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);


}
