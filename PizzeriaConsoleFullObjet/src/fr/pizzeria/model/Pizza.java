package fr.pizzeria.model;

public class Pizza{
	
	private int id;
	private static int nbPizza;
	private String code, name;
	private double price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getNbPizza() {
		return nbPizza;
	}

	public static void addPizza() {
		nbPizza++;
	}
	
	public static void removePizza() {
		nbPizza--;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Pizza(int id, String code, String name, double price) {
		super();
		addPizza();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public Pizza() {
		super();
		addPizza();
	}

}
