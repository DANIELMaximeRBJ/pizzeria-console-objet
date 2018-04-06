package fr.pizzeria.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.service.AppService;

public class PizzaDB implements IPizzaDao {
	public static final ResourceBundle rs = ResourceBundle.getBundle("jdbc");
	public static final String path = rs.getString("path.absolute");
	public static final String user = rs.getString("jdbc.user");
	public static final String pwd = rs.getString("jdbc.pwd");
	private static final Logger LOG = LoggerFactory.getLogger(AppService.class);
	//private 
	public int nbTab = 0;

	public PizzaDB(){
		createDB();
		initPizzaDB();

	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> liste = new ArrayList<>();
		Connection myConnection = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(path, user, pwd);
			statement = myConnection.createStatement();

			resultat = statement.executeQuery("SELECT * FROM PIZZA ");
			while (resultat.next()) {
				String codepizza = resultat.getString("CODE_PIZZA");
				String libellepizza = resultat.getString("LIBELLE_PIZZA");
				Double prix = resultat.getDouble("PRIX_PIZZA");
				String categoriePizza = resultat.getString("CATEGORIE_PIZZA");
				liste.add(new Pizza(codepizza, libellepizza, prix, CategoriePizza.valueOf(categoriePizza)));
			}

		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());
			try {
				myConnection.rollback();
			} catch (SQLException e2) {
				LOG.error(e.getMessage());
			}
			throw new RuntimeException(e);
		} finally {
			try {
				resultat.close();
				statement.close();
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
				throw new RuntimeException(e);
			}
		}
		return liste;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		List<Pizza> liste = new ArrayList<>();
		for (int i = 0; i < liste.size(); i++) {
			nbTab++;
		}
		if (nbTab != 0) {
			nbTab++;
		}
		if (pizza.getCode() != null) {
			liste.add(pizza);
		}

		Connection myConnection = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(path, user, pwd);
			statement = myConnection.createStatement();
			

			resultat = statement.executeQuery(
					"SELECT * FROM PIZZA WHERE CODE_PIZZA IN ('" + pizza.getCode() + "');");
			if (!resultat.next()) {
				statement.executeQuery("INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)" + " VALUES ('"
			+ pizza.getCode() + "','"
			+ pizza.getLibelle() + "',"
			+ pizza.getPrix() + ",'"
			+ pizza.getCategoriePizza() + "');");
			}

			
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());
			try {
				myConnection.rollback();
			} catch (SQLException e2) {
				LOG.error(e.getMessage());
			}
			throw new RuntimeException(e);
		} finally {
			try {
				resultat.close();
				statement.close();
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		List<Pizza> liste = new ArrayList<>();
		nbTab--;
		if (codePizza != null) {
			liste.remove(findPizzaByCode(codePizza));
			liste.add(pizza);
		}
		
		Connection myConnection = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(path, user, pwd);
			statement = myConnection.createStatement();
			
			statement.executeQuery("UPDATE PIZZA SET CODE_PIZZA = '"+pizza.getCode()
			+"', LIBELLE_PIZZA =  '"+pizza.getLibelle() 
			+"', PRIX_PIZZA = "+pizza.getPrix() 
			+", CATEGORIE_PIZZA = '"+pizza.getCategoriePizza()+"'"
			+ "WHERE CODE_PIZZA = '"+codePizza+"';");

			statement.close();
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());
			try {
				myConnection.rollback();
			} catch (SQLException e2) {
				LOG.error(e.getMessage());
			}
			throw new RuntimeException(e);
		} finally {
			try {
				resultat.close();
				statement.close();
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
				throw new RuntimeException(e);
			}
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		List<Pizza> liste = new ArrayList<>();
		if (codePizza != null) {
			liste.remove(findPizzaByCode(codePizza));
		}
		Connection myConnection = null;
		Statement statement = null;
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				myConnection = DriverManager.getConnection(path, user, pwd);
				statement = myConnection.createStatement();
				
				statement.executeQuery("DELETE FROM PIZZA "
				+ "WHERE CODE_PIZZA ='"+ codePizza +"';");

				statement.close();
			} catch (SQLException | ClassNotFoundException e) {
				LOG.error(e.getMessage());
				try {
					myConnection.rollback();
				} catch (SQLException e2) {
					LOG.error(e.getMessage());
				}
				throw new RuntimeException(e);
			} finally {
				try {
					statement.close();
					myConnection.close();
				} catch (SQLException e) {
					LOG.error(e.getMessage());
					throw new RuntimeException(e);
				}
			}

	}

	@Override
	public boolean pizzaExists(String codePizza) {
		if (codePizza != null) {
			return findPizzaByCode(codePizza) != null;
		}
		return false;
	}

	public void createDB(){
		Connection myConnection= null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(path, user, pwd);
			Statement statement = myConnection.createStatement();

			statement.executeQuery("CREATE TABLE IF NOT EXISTS PIZZA("
			+ "ID_PIZZA INT UNIQUE AUTO_INCREMENT,"
			+ "CODE_PIZZA varchar(10) NOT NULL,"
			+ "LIBELLE_PIZZA varchar(30) NOT NULL,"
			+ "PRIX_PIZZA INT NOT NULL," 
			+ "CATEGORIE_PIZZA varchar(20) NOT NULL);"
			);
			statement.close();
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}
		finally {
			try {
				if (myConnection!=null)
					myConnection.rollback();
			} catch (SQLException e1) {
				LOG.debug(e1.getMessage());
			}
		}

	}

	public void initPizzaDB(){
		Connection myConnection = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			myConnection = DriverManager.getConnection(path, user, pwd);
			statement = myConnection.createStatement();

			resultat = statement.executeQuery(
					"SELECT * FROM PIZZA WHERE CODE_PIZZA IN ('PEP','MAR','REIN','FRO','CAN','SAV','ORI','IND');");
			if (!resultat.next()) {
				statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('PEP', 'Pépéronie', 12.50, 'VIANDE');");
                statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('MAR', 'Margherita', 14.00, 'SANS_VIANDE');");
                statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('REIN', 'La Reine', 11.50, 'VIANDE');");
                statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('FRO', 'La 4 fromages', 12.00, 'SANS_VIANDE');");
                statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('CAN', 'La cannibale', 12.50, 'VIANDE');");
                statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('SAV', 'La savoyarde', 13.00, 'VIANDE');");
                statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('ORI', 'L''orientale', 13.50, 'POISSON');");
                statement.executeQuery(
                        "INSERT INTO PIZZA(CODE_PIZZA, LIBELLE_PIZZA, PRIX_PIZZA, CATEGORIE_PIZZA)"
                        + " VALUES ('IND', 'L''indienne', 14.00, 'POISSON');"); 
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());
			try {
				myConnection.rollback();
			} catch (SQLException e2) {
				LOG.error(e.getMessage());
			}
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
				throw new RuntimeException(e);
			}
		}
	}
}
