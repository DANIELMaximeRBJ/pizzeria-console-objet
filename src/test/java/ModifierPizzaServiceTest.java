import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.IPizzaDao;
import fr.pizzeria.service.ModifierPizzaService;

public class ModifierPizzaServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	private static final Logger LOGGER = LoggerFactory.getLogger("monlogger");
	
	@Test(expected=StockageException.class)
	public void testExecuteUC() throws StockageException
	{
		LOGGER.info("Bijour");
		systemInMock.provideLines("MON", "MON", "montagne","12.0","VIANDE");
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		
		
		when(mockedDao.findAllPizzas()).thenReturn(new ArrayList<>());
		doReturn(false).when(mockedDao).pizzaExists(Mockito.anyString());
		
		ModifierPizzaService mps = new ModifierPizzaService();
		
			mps.executeUC(mockedDao , new Scanner(System.in));	
	}

}
