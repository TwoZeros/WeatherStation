package ru.TwoZeros.WeatherStation;

public class HealthIndexDisplay implements Observer, DisplayElement {

    private float heatIndex;
    private Subject weatherData;

    @Override
    public void display() {
        System.out.printf("Индекс %.2f \n", this.heatIndex);
    }

    public HealthIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    private float computeHeatIndex(float t, float rh) {
        float index = (float) ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }

    @Override
    public void update() {
        if (weatherData instanceof WeatherData) {
            float temp = ((WeatherData) weatherData).getTemperature();
            float humidity = ((WeatherData) weatherData).getHumidity();
            this.heatIndex = computeHeatIndex(temp, humidity);
            display();
        }


    }
}
