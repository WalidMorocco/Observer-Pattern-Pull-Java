package mypackage;

import java.util.ArrayList;

public class WeatherData extends Subject {
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() { }
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}


	public float getHumidity() {
		return humidity;
	}


	public float getPressure() {
		return pressure;
	}
	
	

}
