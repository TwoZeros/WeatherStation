package ru.TwoZeros.WeatherStation;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observes;
    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public WeatherData() {
        observes = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observes.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observes.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observes) {
            observer.update();
        }
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }
}

