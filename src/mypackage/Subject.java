package mypackage;

import java.util.ArrayList;

public class Subject {
	private ArrayList observers;
	public float temperature;
	public float humidity;
	public float pressure;
	private boolean changed;
	
	public Subject() {
		observers = new ArrayList();
	}
	
	// Add an observer
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	// Remove an observer if its index is in the observer array
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
			System.out.println("\n TEST \n");
		}
	}
	
	public void setChanged() {
		changed = false;
	};
	
	// Update for every observer the data
	public void notifyObservers(Object arg) {
		if (changed) {
			for (int i = 0; i < observers.size(); i++) {
				Observer observer = (Observer)observers.get(i);
				observer.update(this);
			}
			changed = false;
		}
	};
	
	public void notifyObservers() {
		notifyObservers(null);
	}
	
}
