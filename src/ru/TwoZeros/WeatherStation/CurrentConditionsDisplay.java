package ru.TwoZeros.WeatherStation;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temerature;
    private float humidity;
    private Subject weatherData;

    public  CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.printf("Текущая температура: %.2f \n" +
                          "Влажность: %.2f \n",
                         this.temerature, this.humidity);
    }

    @Override
    public void update() {
        if (weatherData instanceof WeatherData) {
            this.temerature = ((WeatherData) weatherData).getTemperature();
            this.humidity = ((WeatherData) weatherData).getHumidity();
            display();
        }
    }
}
