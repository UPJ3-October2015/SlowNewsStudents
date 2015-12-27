package net.bash.serg.slownews.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;

import java.io.IOException;

/**
 * Created by serega on 25.11.2015.
 */
public class WeatherClientMapper {
    private static final Logger LOGGER = Logger.getLogger(WeatherClientMapper.class);

    public WeatherClientMapper(String jsonstring) throws IOException {
     

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readValue(jsonstring, JsonNode.class);

            JsonNode nameNode = node.get("name");
            String name = nameNode.asText();
            LOGGER.info("name = " + name);

            JsonNode array = node.get("weather");
            JsonNode jsonNode = array.get(2);
            LOGGER.info(jsonNode);
            
            JsonNode child = node.get("main");
            JsonNode tempField = child.get("temp");
            String field = tempField.asText();
            LOGGER.info("temp = " + field);

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
