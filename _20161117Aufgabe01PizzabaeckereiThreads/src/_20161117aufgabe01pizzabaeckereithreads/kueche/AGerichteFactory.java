package _20161117aufgabe01pizzabaeckereithreads.kueche;

import java.util.HashMap;

public abstract class AGerichteFactory {
	
	//attributes
	private ReadInMenu menuReader;
	private HashMap<Integer, String[]> menu;
	
	
	//getters and setters
	public ReadInMenu getMenuReader() {
		return this.menuReader;
	}
	private void setMenuReader(ReadInMenu menuReader) {
		this.menuReader = menuReader;
	}
	public HashMap<Integer, String[]> getMenu() {
		return this.menu;
	}
	private void setMenu(HashMap<Integer, String[]> menu) {
		this.menu = menu;
	}
	
	
	//constructors
	protected AGerichteFactory(ReadInMenu menuReader) {
		this.setMenuReader(menuReader);
		this.setMenu(this.getMenuReader().readInMenu());
	}
	
	
	//features
	protected abstract AGericht createGericht(int num);
	
	
	//standard methods
		//toString
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
