package _20161117aufgabe01pizzabaeckereithreads.kueche;

public class GetraenkAlkohol extends AGetraenk {

	//attributes
	private int num = 0;
	private String name;
	private float price = 0.0f;
	private float kcal = 0.0f;
	private float alc = 0.0f;
	
	
	//getters and setters
	@Override
	public String getType() {
		return "alkoholisches Getraenk";
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
	@Override
	public float getAlc() {
		return this.alc;
	}
	private void setAlc(float alc) {
		if(alc >= 0.0f) {
			this.alc = alc;
		}
	}
	
	
	//constructors
	protected GetraenkAlkohol() {
		this(350, "Bauern Braeu", 3.65f, 43.4f, 5.3f);
	}
	protected GetraenkAlkohol(int num, String name, float price, float kcal, float alc) {
		this.setNum(num);
		this.setName(name);
		this.setPrice(price);
		this.setKcal(kcal);
		this.setAlc(alc);
	}
	
	
	//standard methods
		//toString
	@Override
	public String toString() {
		return	super.toString() + ", Typ: " + this.getType() + ", Nummer: " + this.getNum() + ", Name: " + this.getName() + ", Preis: " + this.getPrice()
				+ ", Kcal: " + this.getKcal() + ", Alkoholgehalt: " + this.getAlc();
	}
}
