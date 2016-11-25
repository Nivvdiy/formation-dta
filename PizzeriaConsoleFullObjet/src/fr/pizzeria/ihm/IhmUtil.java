package fr.pizzeria.ihm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	public void affichePizza(Pizza p, boolean index) {
		if(index){
			System.out.print(p.getId()+".\t -> \t|");
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
		pizzaDaoList.loadPizza();
	}

	public void savePizzaFile() {
		File f = new File ("pizzas.txt");
		int nbPoint = Pizza.getNbPizza()/10;
		int i = 0;

		try{
			FileWriter fw = new FileWriter (f);

			for (Pizza pizza : getPizzaDaoList().findAllPizzas()){
				fw.write (printPizza(pizza));
				fw.write ("\r\n");
				i++;
				if(i==nbPoint){
					System.out.print(".");
				}
			}

			fw.close();
		}
		catch (IOException exception){
			System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}

	private String printPizza(Pizza pizza) {
		return pizza.getId()+";"+pizza.getCode()+";"+pizza.getName()+";"+pizza.getPrice();
	}



}
