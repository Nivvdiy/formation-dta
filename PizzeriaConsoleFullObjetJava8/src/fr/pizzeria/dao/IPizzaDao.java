package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	void loadPizzas();
	void savePizzas();
	void saveNewPizza(Pizza pizza) throws SavePizzaException;
	void updatePizza(int codePizza, Pizza pizza) throws UpdatePizzaException ;
	void removePizza(int codePizza) throws RemovePizzaException;

}
