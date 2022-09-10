package mypackage;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private Subject weatherData;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay( Subject weatherData ) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(Subject o) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
	
	public void display() {
		System.out.println("Current conditions: "
				+ temperature
				+ "F degrees and "
				+ humidity
				+ "% humidity");
	}

}
