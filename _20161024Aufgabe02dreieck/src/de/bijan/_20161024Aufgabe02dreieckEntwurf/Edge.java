package de.bijan._20161024Aufgabe02dreieckEntwurf;

public class Edge {
	
	private double x;
		
	public double getX() {
		return this.x; 
	}
	
	public void setX(double x) {
		this.x = x;
	}
		
	public Edge() {
		this(1);
	}
		
	public Edge(double x) {
		super();
		this.x = x;
	}
		
	@Override
	public String toString() {
		return Double.toString(this.x);
	}
		
	@Override
	public boolean equals(Object otherEdge) {
		return this.x == ((Edge)otherEdge).getX();
	}
	
	@Override
	public Edge clone() {
		return new Edge(this.x);
	}
}
