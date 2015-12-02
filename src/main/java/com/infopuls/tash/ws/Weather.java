package com.infopuls.tash.ws;

import java.util.Map;

public class Weather {

    private Double temperatureK;
    private Double temperatureC;
    private Double pressure;
    private Double temperature_min;
    private Double temperature_max;

    public Weather() {
    }

    public Weather(Double temperatureK) {
        this.temperatureK = temperatureK;
        this.temperatureC = temperatureK - 273.15 ;
    }

    public Weather getCurrentWeather (){
        WeatherWS ws = new WeatherWS();
        Weather weather = new Weather ();
        try {
            Map <String, String> weatherMap = ws.getWeatherMap();
            weather.setTemperatureK(Double.parseDouble(weatherMap.get("temp")));
            weather.setTemperature_max(Double.parseDouble(weatherMap.get("temp_max")));
            weather.setTemperature_min(Double.parseDouble(weatherMap.get("temp_min")));
            return weather;
        }catch (NullPointerException e ){

        }
    return weather;
    }

    public Double getTemperatureK() {
        return temperatureK;
    }

    public void setTemperatureK(Double temperatureK) {
        this.temperatureK = temperatureK;
    }

    public Double getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(Double temperatureC) {
        this.temperatureC = temperatureC;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getTemperature_min() {
        return temperature_min;
    }

    public void setTemperature_min(Double temperature_min) {
        this.temperature_min = temperature_min;
    }

    public Double getTemperature_max() {
        return temperature_max;
    }

    public void setTemperature_max(Double temperature_max) {
        this.temperature_max = temperature_max;
    }
}
