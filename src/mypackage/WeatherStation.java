package mypackage;

public class WeatherStation {

	public static void main(String[] args ) {

		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.registerObserver(currentDisplay);

		System.out.println("Current Display and Statistics Display: \n");
				
		weatherData.setMeasurements(80, 65, 30.4f);
		
		currentDisplay.update(weatherData);
		statisticsDisplay.update(weatherData);
		
		
		weatherData.setMeasurements(82, 70, 29.2f);
		
		System.out.println("\n		Measurements Changed	 \n");
		System.out.println("\nCurrent Display and Forecast Display: \n");
		
		currentDisplay.update(weatherData);
		forecastDisplay.update(weatherData);
		
		weatherData.setMeasurements(78, 90, 29.2f); 
		
		System.out.println("\n		Measurements Changed	 \n");
		System.out.println("\nStatistics Display and Forecast Display: \n");
		
		statisticsDisplay.update(weatherData);
		forecastDisplay.update(weatherData);
		
		weatherData.removeObserver(currentDisplay);
		
		weatherData.setMeasurements(100, 90, 29.2f); 
		
		currentDisplay.update(weatherData);
	}

}
