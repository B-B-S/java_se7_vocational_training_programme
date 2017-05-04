package _20161117aufgabe01pizzabaeckereithreads.kueche;

public abstract class AGericht {
	
	//getters and setters
	public abstract String getCategory ();
	public abstract int getNum();
	public abstract String getType ();
	public abstract String getName ();
	public abstract float getPrice();
	public abstract float getKcal ();
	public abstract float getAlc ();
	
	
	//standard methods
		//toString
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
