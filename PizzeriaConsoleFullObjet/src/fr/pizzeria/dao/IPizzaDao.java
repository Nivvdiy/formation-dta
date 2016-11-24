package fr.pizzeria.dao;

import java.util.ArrayList;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	ArrayList<Pizza> findAllPizzas();
	boolean loadPizza();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(int codePizza, Pizza pizza);
	boolean removePizza(int codePizza);

}
