import java.util.Scanner;

import org.junit.Test;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.AjouterPizzaService;

public class ListerPizzaServiceTest {

	@Test 
	public void testexecuteUC() throws StockageException
	{	
		AjouterPizzaService ajps = new AjouterPizzaService();
		PizzaMemDao pDao = new PizzaMemDao();
		
		ajps.executeUC(pDao, new Scanner(System.in));
	}
}
