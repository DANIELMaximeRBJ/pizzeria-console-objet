import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaMemDao;


public class PizzaMemDaoTest {
	
	@Test
	public void testfindAllPizzas() {
		PizzaMemDao pmd = new PizzaMemDao();
		List<Pizza> listPizzas = pmd.findAllPizzas();
		//Assert.assertEquals(8, listPizzas.size());
		Assert.assertNotNull(listPizzas);
		
	}
	
	@Test
	public void testsaveNewPizza() {
		PizzaMemDao pmd = new PizzaMemDao();		
		int nbPizzas = pmd.findAllPizzas().size();
		
		Pizza newPizza = new Pizza("MON","Montagnarde", 13.50,CategoriePizza.VIANDE);
		pmd.saveNewPizza(newPizza );
		
		List<Pizza> listPizzas2 = pmd.findAllPizzas();						
		Assert.assertNotEquals(nbPizzas,listPizzas2.size());
		
		for(int i =0; i < listPizzas2.size(); i++)
		{
			if(listPizzas2.get(i).getCode().equals("MON"))
			{
				Assert.assertTrue(true);
			}
		}		
	}
	
	@Test
	public void testsaveNewPizza2() {
		PizzaMemDao pmd = new PizzaMemDao();		
		int nbPizzas = pmd.findAllPizzas().size();
		
		Pizza newPizza = new Pizza("","Montagnarde", 13.50,CategoriePizza.VIANDE);
		pmd.saveNewPizza(newPizza );
		
		List<Pizza> listPizzas2 = pmd.findAllPizzas();						
		Assert.assertNotEquals(nbPizzas,listPizzas2.size());
		
		for(int i =0; i < listPizzas2.size(); i++)
		{
			if(listPizzas2.get(i).getCode().equals(null))
			{
				Assert.assertTrue(false);
			}
		}		
	}
	
	@Test
	public void testsaveNewPizza3() {
		PizzaMemDao pmd = new PizzaMemDao();		
		int nbPizzas = pmd.findAllPizzas().size();
		
		Pizza newPizza = new Pizza("","", 0.0,CategoriePizza.VIANDE);
		pmd.saveNewPizza(newPizza );
		
		List<Pizza> listPizzas2 = pmd.findAllPizzas();						
		Assert.assertNotEquals(nbPizzas,listPizzas2.size());
		
		for(int i =0; i < listPizzas2.size(); i++)
		{
			if(listPizzas2.get(i).getCode().equals(null))
			{
				Assert.assertTrue(false);
			}
		}		
	}
	
	@Test
	public void testupdatePizza() {
		PizzaMemDao pmd = new PizzaMemDao();		
		int nbPizzas = pmd.findAllPizzas().size();
		
		Pizza newPizza = new Pizza("MON","Montagnarde", 13.50,CategoriePizza.VIANDE);
		pmd.updatePizza("PEP", newPizza);
		
		List<Pizza> listPizzas2 = pmd.findAllPizzas();
		
		for(int i =0; i < listPizzas2.size(); i++)
		{
			if(listPizzas2.get(i).getCode().equals("PEP"))
			{
				Assert.assertTrue(false);
			}
		}
		for(int i =0; i < listPizzas2.size(); i++)
		{
			if(listPizzas2.get(i).getCode().equals("MON"))
			{
				Assert.assertTrue(true);
			}
		}
		
		Assert.assertEquals(nbPizzas,listPizzas2.size());		
	}
	
	@Test
	public void testdeletePizza() {
		PizzaMemDao pmd = new PizzaMemDao();		
		int nbPizzas = pmd.findAllPizzas().size();
		
		pmd.deletePizza("PEP");
		
		List<Pizza> listPizzas2 = pmd.findAllPizzas();
		
		for(int i =0; i < listPizzas2.size(); i++)
		{
			if(listPizzas2.get(i).getCode().equals("PEP"))
			{
				Assert.assertTrue(false);
			}
		}
		
		Assert.assertNotEquals(nbPizzas,listPizzas2.size());		
	}
	
	@Test
	public void testdeletePizza2() {
		PizzaMemDao pmd = new PizzaMemDao();		
		int nbPizzas = pmd.findAllPizzas().size();
		
		pmd.deletePizza("");
		
		List<Pizza> listPizzas2 = pmd.findAllPizzas();
		
		for(int i =0; i < listPizzas2.size(); i++)
		{
			if(listPizzas2.get(i).getCode().equals("null"))
			{
				Assert.assertTrue(false);
			}
		}
		
		Assert.assertEquals(nbPizzas,listPizzas2.size());		
	}
	
	@Test
	public void testfindPizzaByCode() {
		PizzaMemDao pmd = new PizzaMemDao();
		String codePizza = "IND";
		
		Pizza pizzaTrouver = pmd.findPizzaByCode(codePizza);
		Assert.assertTrue(pmd.pizzaExists(codePizza));
		Assert.assertNotNull(pizzaTrouver);	
		
	}
	
	//@Test
	public void testfindPizzaByCode2() {
		PizzaMemDao pmd = new PizzaMemDao();
		String codePizza = "";
		
		Pizza pizzaTrouver = pmd.findPizzaByCode(codePizza);
		Assert.assertFalse(pmd.pizzaExists(codePizza));
		Assert.assertNull(pizzaTrouver);	
		
	}
	
	@Test
	public void testpizzaExists() {
		PizzaMemDao pmd = new PizzaMemDao();
		String codePizza = "IND";
		
		boolean pizzaTrouver = pmd.pizzaExists(codePizza);
		Assert.assertTrue(pizzaTrouver);
		
	}
	
	@Test
	public void testpizzaExists2() {
		PizzaMemDao pmd = new PizzaMemDao();
		String codePizza = "";
		
		boolean pizzaTrouver = pmd.pizzaExists(codePizza);
		Assert.assertFalse(pizzaTrouver);
		
	}
	
	
	
	
}
