package _20161117aufgabe01pizzabaeckereithreads.main;

import _20161117aufgabe01pizzabaeckereithreads.consumers.PizzaBaecker;
import _20161117aufgabe01pizzabaeckereithreads.producers.cli.CLI;
import _20161117aufgabe01pizzabaeckereithreads.producers.randomizer.Randomizer;
import _20161117aufgabe01pizzabaeckereithreads.que.Que;

public class PizzaBaeckereiThreadsMain {

	public static void main(String[] args) {
		Que que = new Que(50, 70);
		
		Thread[] producers = {	
									new CLI("Nutzerkonsole", que, 500),
									new Randomizer("Zufallsgenerator", que, 2000)
		};
		
		Thread[] consumers = {
									new PizzaBaecker("Luigi", que, 40000),
									new PizzaBaecker("Mario", que, 40000),
									new PizzaBaecker("Alfonso", que, 40000),
									new PizzaBaecker("Donatello", que, 40000),
									new PizzaBaecker("Leonardo", que, 40000)
		};
		
		//start producers
		for(Thread producer : producers) {
			producer.start();
		}
		
		//start consumers
		for(Thread consumer : consumers) {
			consumer.start();
		}
	}

}
