package fr.pizzeria.service;


public class MenuServiceFactory {
	
	public MenuService getInstance(int choice)
	{
		if (choice == 1)
	 	{
			ListerPizzasService lps = new ListerPizzasService();
			return lps;
	 	}
		if (choice == 2)
	 	{
			AjouterPizzaService aps = new AjouterPizzaService();
			return aps;
	 	}
		if (choice == 3)
	 	{
			ModifierPizzaService mps = new ModifierPizzaService();
			return mps;
	 	}
		if (choice == 4)
	 	{
			SupprimerPizzaService sps = new SupprimerPizzaService();
			return sps;
	 	}		
		return null;		
	}

}
