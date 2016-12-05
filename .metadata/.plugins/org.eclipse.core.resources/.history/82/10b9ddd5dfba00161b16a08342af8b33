package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.file.PizzaDaoFile;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Pizza p1 = new Pizza("MAR", null, 0, null, false);

		Pizza p2 = new Pizza("MAR", null, 0, null, false);

		System.out.println("p1=p2 ? " + p1.equals(p2));

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new PizzaDaoFile("pizzas.txt"));

		MainMenu mainMenu = new MainMenu(ihmUtil);

		mainMenu.run();
	}

}
