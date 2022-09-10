package mypackage;

public class StatisticsDisplay implements Observer, DisplayElement {
	private Subject weatherData;
	private float temperature;
	private float minTemp;
	private float maxTemp;
	private float avgTemp;
	
	public StatisticsDisplay( Subject weatherData ) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(Subject o) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			if (temperature < minTemp) minTemp = weatherData.getTemperature();
			if (temperature > maxTemp) maxTemp = weatherData.getTemperature();
			avgTemp = (avgTemp + temperature) / 2;
			display();	
		}
	}
	
	public void display() {
		System.out.println("Avg/Max/Min Temperature = " + minTemp + "/" + maxTemp + "/" + avgTemp);
	}
	
}
