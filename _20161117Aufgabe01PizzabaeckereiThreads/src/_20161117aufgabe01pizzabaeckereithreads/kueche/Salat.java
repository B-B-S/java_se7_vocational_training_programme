package _20161117aufgabe01pizzabaeckereithreads.kueche;

public class Salat extends ASalat {
	
	//attributes
	private int num = 0;
	private String name;
	private float price = 0.0f;
	private float kcal = 0.0f;
	
	
	//getter and setter
	@Override
	public String getType() {
		return "Salat";
	}
	@Override
	public int getNum() {
		return this.num;
	}
	private void setNum(int num) {
		if(num >= 0) {
			this.num = num;
		}
	}
	@Override
	public String getName() {
		return this.name;
	}
	private void setName(String name) {
		this.name = name;
	}
	@Override
	public float getPrice() {
		return this.price;
	}
	private void setPrice(float price) {
		if(price >= 0.0f) {
			this.price = price;
		}
	}
	@Override
	public float getKcal() {
		return this.kcal;
	}
	private void setKcal(float kcal) {
		if(kcal >= 0.0f) {
			this.kcal = kcal;
		}
	}
	
	
	//constructors
	protected Salat() {
		this(200, "Bauensalat", 5.45f, 220.4f);
	}
	protected Salat(int num, String name, float price, float kcal) {
		this.setNum(num);
		this.setName(name);
		this.setPrice(price);
		this.setKcal(kcal);
	}
	
	
	//standard methods
			//toString
	@Override
	public String toString() {
		return	super.toString() + ", Typ: " + this.getType() + ", Nummer: " + this.getNum() + ", Name: " + this.getName()
				+ ", Preis: " + this.getPrice() + ", Kcal: " + this.getKcal();
	}
}
