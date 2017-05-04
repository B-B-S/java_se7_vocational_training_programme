package de.bijan._20161024Aufgabe02dreieckEntwurf;

public class Triangle {
	
	private Edge a;
	private Edge b;
	private Edge c;
	
	public double getA() {
		return this.a.getX();
	}
	
	public double getB() {
		return this.b.getX();
	}
	
	public double getC() {
		return this.c.getX();
	}
	
	public void setA(double a) {
		this.a.setX(a);  
	}
	
	public void setB(double b) {
		this.b.setX(b);
	}
	
	public void setC(double c) {
		this.c.setX(c);
	}
	
	public Triangle () {
		super();
		this.a = new Edge();
		this.b = new Edge();
		this.c = new Edge();
	}
	
	public Triangle (double a, double b, double c) {
		super();
		this.a = new Edge(a);
		this.b = new Edge(b);
		this.c = new Edge(c);
	}
	
	@Override
	public String toString() {
		return "Triangle edges: a = " + this.a.toString() + " , b = " + this.b.toString() + " , c = " + this.c.toString() + "!";
	}
	
	@Override
	public boolean equals(Object otherTriangle) {
		return	this.a.getX() == ((Triangle)otherTriangle).getA()
					&&
				this.b.getX() == ((Triangle)otherTriangle).getB()
					&&
				this.c.getX() == ((Triangle)otherTriangle).getC()
		;
	}
	
	@Override
	public Triangle clone() {
		return new Triangle(this.a.getX(), this.b.getX(), this.c.getX());
	}

	
	
	public String type() {
		if(isEquilateral()) {
			return "equilateral";
		} else if(isIsosceles()) {
			return "isosceles";
		} else {
			return "standard";
		}
	}
	
	//gleichschenklig
	private boolean isIsosceles() {
		return this.a.getX() == this.b.getX() || this.a.getX() == this.c.getX() || this.b.getX() == this.c.getX();
	}
	
	//gleichseitig
	private boolean isEquilateral() {
		return this.a.getX() == this.b.getX() && this.a.getX() == this.c.getX() && this.b.getX() == this.c.getX();
	}
	
	
	
	//rechtwinkelig
	public boolean isPerpendicular() {
		double[] sortArray = {this.a.getX(), this.b.getX(), this.c.getX()};
		//sort array elements in ascending order
		/*for(int j = 1; j < sortArray.length; j++) {
			for(int i = 1; i < sortArray.length; i++) {
				if(sortArray[i-1] > sortArray[i]) {
					double intermediaryX = sortArray[i-1];
					sortArray[i-1] = sortArray[i];
					sortArray[i] = intermediaryX;
				}
			}
		}*/
		//sort array elements in ascending order using bubble sort approach
		for(int i = 0; i < sortArray.length - 1; i++) {
			if(sortArray[i] > sortArray[i + 1]) {
				double intermediaryX = sortArray[i];
				sortArray[i] = sortArray[i + 1];
				sortArray[i + 1] = intermediaryX;
				
				//reset counter until Array is completely sorted in ascending order
				i = -1;
			}
		}
		return Math.pow(sortArray[0], 2) + Math.pow(sortArray[1], 2) == Math.pow(sortArray[2], 2);
	}
	
	
	
	//Flaeche
	public double calcArea(){
		//half of periphery
		double s = this.calcPeriphery()/2;
		return Math.sqrt(s * (s - this.a.getX()) * (s - this.b.getX()) * (s - this.c.getX()));
	}
	
	//Umfang
	public double calcPeriphery() {
		return this.a.getX() + this.b.getX() + this.c.getX();
	}
}
