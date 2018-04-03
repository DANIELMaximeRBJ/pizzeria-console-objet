import java.util.Scanner;

import org.junit.Test;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.AjouterPizzaService;

public class AjouterPizzaServiceTest {
	@Test 
	public void testexecuteUC() throws SavePizzaException 
	{	
		AjouterPizzaService ajps = new AjouterPizzaService();
		PizzaMemDao pDao = new PizzaMemDao();
		
		ajps.executeUC(pDao, new Scanner(System.in));
	}
}
