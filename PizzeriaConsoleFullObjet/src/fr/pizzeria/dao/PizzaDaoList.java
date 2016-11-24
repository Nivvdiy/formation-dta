package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDaoList implements IPizzaDao{
	
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

	@Override
	public ArrayList<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		pizzas.add(pizza);
		return true;
	}

	@Override
	public boolean updatePizza(int codePizza, Pizza pizza) {
		pizzas.set(codePizza-1, pizza);
		return true;
	}

	@Override
	public boolean removePizza(int codePizza) {
		pizzas.remove(codePizza-1);
		return true;
	}

	@Override
	public boolean loadPizza() {
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14));
		pizzas.add(new Pizza(2, "ORI", "Oriental", 16));
		return true;
	}

}