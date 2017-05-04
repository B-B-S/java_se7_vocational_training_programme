package _20161117aufgabe01pizzabaeckereithreads.kueche;

public abstract class APizza extends AGericht {
	
	//getters and setters
	public String getCategory() {
		return "Pizza";
	}
	public float getAlc() {
		return 0.0f;
	}
	
	
	//standard methods
			//toString
	@Override
	public String toString() {
		return super.toString() + " Kategorie: " + this.getCategory() + ", Alkoholgehalt: " + this.getAlc();
	}
}
