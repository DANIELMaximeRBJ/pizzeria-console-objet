package fr.pizzeria.service;


public class MenuServiceFactory {
	
	public MenuService getInstance(int choice)
	{
		if (choice == 1)
	 	{
			MenuService lps = new ListerPizzasService();
			return lps;
	 	}
		if (choice == 2)
	 	{
			MenuService aps = new AjouterPizzaService();
			return aps;
	 	}
		if (choice == 3)
	 	{
			MenuService mps = new ModifierPizzaService();
			return mps;
	 	}
		if (choice == 4)
	 	{
			MenuService sps = new SupprimerPizzaService();
			return sps;
	 	}		
		return null;		
	}

}
