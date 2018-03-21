package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.model.PizzaMemDao;

public abstract class MenuService {
 	int rep = 0;
 	String repCode = "", repLibelle = "", repNouvCode = "";
 	double repPrix = 0.0;
 	Scanner questionUser = new Scanner(System.in) ;
	public abstract void executeUC(PizzaMemDao pizza);

}
