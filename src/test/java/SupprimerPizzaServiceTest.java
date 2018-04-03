import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaMemDao;
import fr.pizzeria.service.AjouterPizzaService;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class SupprimerPizzaServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test 
	public void testexecuteUC() throws StockageException
	{	
		AjouterPizzaService ajps = new AjouterPizzaService();
		PizzaMemDao pDao = new PizzaMemDao();
		
		try {
			systemInMock.provideLines("PEP");
			ajps.executeUC(pDao);
			
		} catch (Exception e) {
			fail("Le test est en echec");
		}
	}

}
