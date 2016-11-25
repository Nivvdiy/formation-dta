package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.FileWR;
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

	public void affichePizza(Pizza p, boolean index) {
		if(index){
			System.out.print(pizzaDaoList.findAllPizzas().indexOf(p)+1+".\t -> \t|");
		}
		System.out.print(p.getCode()+"|\t|"+p.getName());
		if(p.getName().length()<31){
			System.out.print("\t");
		}
		if(p.getName().length()<23){
			System.out.print("\t");
		}
		if(p.getName().length()<15){
			System.out.print("\t");
		}
		if(p.getName().length()<7){
			System.out.print("\t");
		}
		System.out.printf("|("+"%.2f"+"€)|\n",p.getPrice());
	}

	public void initialize(){
		pizzaDaoList.loadPizzas();
	}

	public void savePizzaFile() {
		pizzaDaoList.getFileWR().setAllLines(FileWR.toStringList(pizzaDaoList.findAllPizzas()));
		pizzaDaoList.savePizzas();
	}



}
