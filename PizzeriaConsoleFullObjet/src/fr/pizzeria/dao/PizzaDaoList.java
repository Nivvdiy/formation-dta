package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import fr.pizzeria.model.Pizza;

public class PizzaDaoList implements IPizzaDao{

	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

	public int getNbPizza(){
		return Pizza.getNbPizza();
	}

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
		Pizza.removePizza();
		return true;
	}

	@Override
	public boolean loadPizza() {
		String fichier ="pizzas.txt";

		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String line;
			while ((line=br.readLine())!=null){
				String[] pizzaLine = line.split(";");
				pizzas.add(new Pizza(Integer.parseInt(pizzaLine[0]),pizzaLine[1],pizzaLine[2], Double.parseDouble(pizzaLine[3])));
			}
			br.close(); 
		}		
		catch (Exception e){
			return false;
		}
		return true;
	}

}