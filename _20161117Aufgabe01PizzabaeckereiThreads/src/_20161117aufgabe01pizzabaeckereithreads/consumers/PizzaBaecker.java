package _20161117aufgabe01pizzabaeckereithreads.consumers;

import java.util.Vector;

import _20161117aufgabe01pizzabaeckereithreads.kueche.AGericht;
import _20161117aufgabe01pizzabaeckereithreads.kueche.Kueche;
import _20161117aufgabe01pizzabaeckereithreads.que.Que;

public class PizzaBaecker extends Thread {
	
	//attributes
	private Que que;
	private int sleepTime = 1;
	private Kueche kueche;
	
	
	//getters and setters (attributes can only be accessed internally)
	private Que getQue() {
		return this.que;
	}
	private void setQue(Que que) {
		this.que = que;
	}
	private int getSleepTime() {
		return this.sleepTime;
	}
	private void setSleepTime(int sleepTime) {
		if(sleepTime >= 1) {
			this.sleepTime = sleepTime;
		}
	}
	private Kueche getKueche() {
		return this.kueche;
	}
	private void setKueche(Kueche kueche) {
		this.kueche = kueche;
	}
	
	
	//constructors
	public PizzaBaecker(String name, Que que) {
		this(name, que, 1000);
	}
	public PizzaBaecker(String name, Que que, int sleepTime) {
		super(name);
		this.setQue(que);
		this.setSleepTime(sleepTime);
		this.setKueche(new Kueche());
	}
	
	
	//standard methods
		//toString
	@Override
	public String toString() {
		return super.toString() + " que: " + this.getQue() + " sleepTime: " + this.getSleepTime(); 
	}
	
	
	//features
	@Override
	public void run() {
		try{
			while(true) {
				//retrieve order
				Vector<Integer> order = this.getQue().retrieveOrder();
				
				//extract order number from first vector element
				int orderNumber = order.firstElement();
				order.remove(0);
				
				//initialize variable to store processed order
				StringBuffer output = new StringBuffer();
				output.append("Bestellung " + orderNumber + " ist fertig, bestehend aus:\n");
				
				//create gericht objects contained in order
				for(Integer element : order) {
					AGericht gericht = this.getKueche().createGericht(element);
					if(gericht != null) {
						output.append(gericht);
						output.append("\n");
					}
				}
				
				//report order
				System.out.println(output);
				
				//have thread sleep for specified time
				sleep((int) (Math.random() * this.getSleepTime()));
			}
		} catch(InterruptedException e) {
			//do nothing
		}
	}
}
