package fr.pizzeria.service;


import java.io.IOException;

import com.itextpdf.text.DocumentException;

import fr.pizzeria.model.PizzaMemDao;
public class ListerPizzasService extends MenuService {
	
	public void executeUC(PizzaMemDao dao)
	{
	PDFgenerateur pg = new PDFgenerateur();
 		System.out.println("\n Lister les pizzas \n");
 		try {
 			pg.init();
		} catch (DocumentException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(int i=0; i < dao.findAllPizzas().size() ; i++)
 		{
 			if(dao.findAllPizzas().get(i) != null)
 			{
 				//System.out.println(dao.findAllPizzas().get(i).getCode() + "->" + dao.findAllPizzas().get(i).getLibelle() + "(" +  dao.findAllPizzas().get(i).getPrix() + "€) (" + dao.findAllPizzas().get(i).toString() + ")");
 				System.out.println(dao.findAllPizzas().get(i).toString());
 	 			try {
 	 				pg.text(dao.findAllPizzas().get(i).toString());
				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
 			}	 

 		}
			try {
				pg.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	
}
