package fr.pizzeria.console;

public enum CategoriePizza {
	
	VIANDE ("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String catePizza;
	
	private CategoriePizza (String catePizza)
	{
		this.catePizza = catePizza;
	}
	
	public String getCategoriepizza()
	{
		return catePizza;
	}
	
	public void setCategoriepizza(String catePizza)
	{
		this.catePizza = catePizza;
	}

}
