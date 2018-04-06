package fr.pizzeria.model;

import java.util.ArrayList;

import java.util.List;

import fr.pizzeria.console.CategoriePizza;

public class PizzaMemDao implements IPizzaDao {
	
	private List<Pizza> liste = new ArrayList<>();
	public int nbTab = 0;

	public PizzaMemDao() {
		liste.add(new Pizza(0, "PEP", "Pépéronie", 12.50, CategoriePizza.VIANDE));
		liste.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		liste.add(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		liste.add(new Pizza(3, "FRO", "La 4 Fromages", 12.00, CategoriePizza.SANS_VIANDE));
		liste.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		liste.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		liste.add(new Pizza(6, "ORI", "L’orientale", 13.50, CategoriePizza.POISSON));
		liste.add(new Pizza(7, "IND", "L’indienne", 14.00, CategoriePizza.SANS_VIANDE));

	}

	@Override
	public List<Pizza> findAllPizzas() {
		return liste;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		for (int i = 0; i < liste.size(); i++) {
			nbTab++;
		}
		if (nbTab != 0) {
			nbTab++;
		}
		if (pizza.getCode() != null) {
			liste.add(pizza);
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		nbTab--;
		if (codePizza != null) {
			liste.remove(findPizzaByCode(codePizza));
			liste.add(pizza);
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		if (codePizza != null) {
			liste.remove(findPizzaByCode(codePizza));
		}
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		if (codePizza != null) {
			return findPizzaByCode(codePizza) != null;
		}
		return false;
	}

}
