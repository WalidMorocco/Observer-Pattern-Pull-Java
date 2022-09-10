package mypackage;

public class ForecastDisplay implements Observer, DisplayElement {
	private Subject weatherData;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public ForecastDisplay( Subject weatherData ) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(Subject o) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			display();
		}
	}
	
	public void display() {
		System.out.println("Forecast: More of the same");
	}
	
}
