package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.RemovePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoList implements IPizzaDao{

	private List<Pizza> pizzas = new ArrayList<Pizza>();
	private FileWR fileWR = new FileWR("pizzas.txt");

	public int getNbPizza(){
		return Pizza.getNbPizza();
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException{
		if(!isValid(pizza)){
			throw new SavePizzaException(pizza);
		}
		pizzas.add(pizza);
	}

	@Override
	public void updatePizza(int codePizza, Pizza pizza) throws UpdatePizzaException{
		if(!isValid(pizza)&!isValid(codePizza)){
			throw new UpdatePizzaException(codePizza, pizza, getNbPizza());
		}
		pizzas.set(codePizza-1, pizza);
	}

	@Override
	public void removePizza(int codePizza) throws RemovePizzaException{
		if(!isValid(codePizza)){
			throw new RemovePizzaException(codePizza, getNbPizza());
		}
		pizzas.remove(codePizza-1);
		Pizza.removePizza();
	}

	private boolean isValid(int codePizza) {
		return (0<codePizza)&(codePizza<pizzas.size()+1);
	}

	private boolean isValid(Pizza pizza) {
		return pizza!=null & pizza.getCode().length()==3 & pizza.getName().length()>0 & pizza.getPrice()>0;
	}

	@Override
	public void loadPizzas() {
		if(fileWR.readFile()){
			pizzas = fileWR.toPizzaList();
		}
	}

	@Override
	public void savePizzas() {
		fileWR.writeFile();
	}

	public FileWR getFileWR() {
		return fileWR;
		
	}

}