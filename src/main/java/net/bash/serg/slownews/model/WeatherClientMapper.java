package net.bash.serg.slownews.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by serega on 25.11.2015.
 */
public class WeatherClientMapper {
    private String speed;
    private String temp;

    public WeatherClientMapper(String jsonstring) throws IOException {
     

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            JsonNode node = objectMapper.readValue(jsonstring, JsonNode.class);

            JsonNode main = node.get("main");
            JsonNode temp = main.get("temp");
            String child = temp.asText();
            setTemp(child);

            JsonNode wind = node.get("wind");
            JsonNode speed = wind.get("speed");
            String child2 = speed.asText();
            setSpeed(child2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
