package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.Pizza.Category;

public class FileWR implements IFileWR {

	private List<String> lines;
	private String filePath;

	public FileWR(String filePath) {
		this.filePath = filePath;
		this.lines = new ArrayList<String>();
	}

	@Override
	public boolean writeFile() {
		File f = new File(filePath);

		try {
			FileWriter fw = new FileWriter(f);

			for (String line : lines) {
				fw.write(line);
				fw.write("\r\n");
			}

			fw.close();
		} catch (IOException exception) {
			return false;
		}
		return true;
	}

	@Override
	public boolean readFile() {
		try {
			InputStream ips = new FileInputStream(filePath);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<String> getAllLines() {
		return lines;
	}

	@Override
	public void setAllLines(List<String> list) {
		this.lines = list;
	}

	public List<Pizza> toPizzaList() {
		List<Pizza> pizzas = new ArrayList<Pizza>();
		for (String line : lines) {
			String[] temp = line.split(";");
			pizzas.add(new Pizza(temp[0], temp[1], Double.parseDouble(temp[2]), Category.parseCategory(temp[3]), true));
		}
		return pizzas;
	}

	public static List<String> toStringList(List<Pizza> list) {
		List<String> temps = new ArrayList<String>();
		for (Pizza pizza : list) {
			temps.add(pizza.getCode() + ";" + pizza.getName() + ";" + pizza.getPrice() + ";"
					+ pizza.getCategory().toString());
		}
		return temps;
	}

}
