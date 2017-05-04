package _20161117aufgabe01pizzabaeckereithreads.producers.randomizer;

import java.util.Vector;
import _20161117aufgabe01pizzabaeckereithreads.kueche.Kueche;
import _20161117aufgabe01pizzabaeckereithreads.que.Que;

public class Randomizer extends Thread {
	
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
	public Randomizer(String name, Que que) {
		this(name, que, 500);
	}
	public Randomizer(String name, Que que, int sleepTime) {
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
		try {
			while(true) {
				//store random order in que
				this.getQue().storeOrder(this.randomizedOrder());
				
				//have thread sleep for specified time
				sleep((int) (Math.random() * this.getSleepTime()));
			}
		} catch (InterruptedException e) {
			//do nothing
		}
	}
	
	
	//internal helper methods
	/**
	 * ----------------------------------------
	 * method is to be called in the thread's run method
	 * ----------------------------------------
	 * 
	 * method reads in all available selection numbers and adds some of these to an order, randomly
	 * it then returns the order
	 * if no selection number is available at all, one single integer with the value of 1 will be added to the order and an exception will be thrown
	 * 
	 * @return Vector<Integer> randomOrder order containing randomly chosen selection numbers
	 */
	private Vector<Integer> randomizedOrder() {
		Vector<Integer> randomOrder = new Vector<>();
		
		//read out all available selections
		Vector<Integer> availableSelections = this.getKueche().availableSelections();
		
		//get maximum index available
		int randMax = availableSelections.size() - 1;
		
		//pick random selections based on available indexes and add to order if at least one selection is available
		//repeat step a random amount of times (at least once)
		//if no selection is available at all add a value of 1 to order and throw exception
		try {
			if(randMax >= 0) {
				for(int i = -1; i < (int)(5 * Math.random()); i++) {
					randomOrder.add(availableSelections.get((int)(randMax * Math.random())));
				}
			} else {
				randomOrder.add(1);
				throw new RuntimeException("No selection numbers are available for randomizer to pick from!");
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		//return random order
		return randomOrder;
	}
}
