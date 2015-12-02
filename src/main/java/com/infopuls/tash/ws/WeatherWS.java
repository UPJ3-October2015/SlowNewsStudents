package com.infopuls.tash.ws;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherWS {
    final private String ENDPOINT = "http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0";
    private Map<String, String> weatherMap = new HashMap();

    public WeatherWS () {
        try {

            String responseEntity = ClientBuilder.newClient()
                    .target(ENDPOINT).path("")
                    .request().get(String.class);

            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(responseEntity);
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
                    jsonToken = parser.nextToken();
                    weatherMap.put(fieldName, parser.getValueAsString());
//                    System.out.println(fieldName + " " + parser.getValueAsString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map  getWeatherMap (){
        return this.weatherMap;
    }

    @Override
    public String toString() {
        String  result = "WeatherWS{" +
                "weatherMap=";
        for(Map.Entry<String, String> e : this.weatherMap.entrySet()) {
            result = result +
                    e.getKey() + " : " + e.getValue();
        }
        return result +
                '}';
    }
}
