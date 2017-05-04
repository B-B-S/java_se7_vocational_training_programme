package _20161117aufgabe01pizzabaeckereithreads.kueche;

public abstract class AGetraenk extends AGericht {
	
	//getters and setters
	public String getCategory() {
		return "Getraenk";
	}

	
	//standard methods
			//toString
	@Override
	public String toString() {
		return super.toString() + " Kategorie: " + this.getCategory();
	}
}
