package net.bash.serg.slownews.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by serega on 25.11.2015.
 */
public class WeatherClientMapper {

    public WeatherClientMapper(String jsonstring) throws IOException {
     

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            JsonNode node = objectMapper.readValue(jsonstring, JsonNode.class);

            JsonNode nameNode = node.get("name");
            String name = nameNode.asText();
            System.out.println("name = " + name);

            JsonNode array = node.get("weather");
            JsonNode jsonNode = array.get(2);
            System.out.println(jsonNode);
            
            JsonNode child = node.get("main");
            JsonNode tempField = child.get("temp");
            String field = tempField.asText();
            System.out.println("temp = " + field);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
