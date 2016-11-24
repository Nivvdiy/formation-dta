package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoList;
import fr.pizzeria.model.Pizza;

public class IhmUtil {

	private Scanner scanner;
	private PizzaDaoList pizzaDaoList;

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public PizzaDaoList getPizzaDaoList() {
		return pizzaDaoList;
	}

	public void setPizzaDaoList(PizzaDaoList pizzaDaoList) {
		this.pizzaDaoList = pizzaDaoList;
	}

	public IhmUtil(Scanner scanner, PizzaDaoList pizzaDaoList) {
		this.scanner = scanner;
		this.pizzaDaoList = pizzaDaoList;
	}

	public void affichePizza(Pizza p) {
		System.out.println(p.getId()+". -> "+p.getCode()+" "+p.getName()+" ("+p.getPrice()+")");
	}
	
	

}
