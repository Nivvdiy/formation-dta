package fr.pizzeria.dao;

import java.util.List;

public interface IFileWR {
	
	boolean writeFile();
	boolean readFile();
	List<String> getAllLines();
	void setAllLines(List<String> lines);

}
