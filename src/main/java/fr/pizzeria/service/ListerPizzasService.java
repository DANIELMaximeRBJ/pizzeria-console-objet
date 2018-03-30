package fr.pizzeria.service;


import java.io.IOException;

import com.itextpdf.text.DocumentException;

import fr.pizzeria.model.PizzaMemDao;
public class ListerPizzasService extends MenuService {
	
	public void executeUC(PizzaMemDao dao)
	{
	PDFgenerateur pg = new PDFgenerateur();
	LOG.info("\n Lister les pizzas \n");
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
 				LOG.info(dao.findAllPizzas().get(i).toString());
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
