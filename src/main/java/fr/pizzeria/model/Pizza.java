package fr.pizzeria.model;

import fr.pizzeria.console.CategoriePizza;

public class Pizza {

	private int id; 
	private String code, libelle;
	private double prix;
	private CategoriePizza cp;
	
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
	
	public String toString()
	{
		return this.cp.getCategoriepizza();
	}
/*	public static void main(String[] args) {
		Pizza monta = new Pizza("17","montagnardes",9.85);
		System.out.println("Id :" + monta.id);
		System.out.println("Code :" + monta.code);
		System.out.println("Libelle :" + monta.libelle);
		System.out.println("Prix : " + monta.prix + "\n");
		
		Pizza pepero = new Pizza(10101010,"12","peperonies",8.75);
		System.out.println("Id :" + pepero.id);
		System.out.println("Code :" + pepero.code);
		System.out.println("Libelle :" + pepero.libelle);
		System.out.println("Prix : " + pepero.prix + "\n");
	}*/
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
