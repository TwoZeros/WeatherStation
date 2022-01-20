package ru.TwoZeros.WeatherStation;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        HealthIndexDisplay healthIndexDisplay = new HealthIndexDisplay(weatherData);
        weatherData.setMeasurements(70, 25, 30);
    }
}
