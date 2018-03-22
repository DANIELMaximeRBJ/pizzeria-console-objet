package fr.pizzeria.model;


import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

public class Pizza {

	private int id; 
	
	@ToString(separateur = " -> ",upperCase = true)
	private String code;
	
	@ToString(separateur = " (",upperCase = false)
	private String libelle;
	
	@ToString(separateur = "€) (")
	private double prix;
	
	@ToString(separateur = ")",upperCase = false)
	private CategoriePizza cp;
	
	//StringUtils su = new StringUtils();
	
	public Pizza(String code, String libelle, double prix, CategoriePizza cp)
	{
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		id = 123456789;
		this.cp = cp;
	}
	
	public Pizza(int id,String code, String libelle, double prix, CategoriePizza cp)
	{
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.cp = cp;
	}
	
	/*public String toString()
	{
		return this.cp.getCategoriepizza();
	}*/
	
	public String toString()
	{
		return StringUtils.getAnnotation(this);
		//return this.id + this.code + this.libelle + this.prix + this.cp.getCategoriepizza();
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public String getLibelle()
	{
		return libelle;
	}
	
	public double getPrix()
	{
		return prix;
	}
	

}
