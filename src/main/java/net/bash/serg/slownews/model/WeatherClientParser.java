package net.bash.serg.slownews.model;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by basoy on 11/23/15.
 */

public class WeatherClientParser {
    private String result;
   public WeatherClientParser(){
           try {

               Client client =  Client.create();

               WebResource webResource = client
                       .resource("http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0");

               ClientResponse response = webResource.accept("application/json")
                       .get(ClientResponse.class);

               if (response.getStatus() != 200) {
                   throw new RuntimeException("Failed : HTTP error code : "
                           + response.getStatus());
               }

               String output = response.getEntity(String.class);

               WeatherClientMapper weatherClientMapper = new WeatherClientMapper(output);

               JsonFactory factory = new JsonFactory();
               JsonParser parser  = factory.createParser(output);

               Weather weather = new Weather();
               while(!parser.isClosed()){
                   JsonToken jsonToken = parser.nextToken();

                   if(JsonToken.FIELD_NAME.equals(jsonToken)){
                       String fieldName = parser.getCurrentName();
                       System.out.println(fieldName);
                       jsonToken = parser.nextToken();
                       System.out.println(parser.getValueAsString());

                       if("base".equals(fieldName)){
                           weather.setBase(parser.getValueAsString());
                       }
                       if ("name".equals(fieldName)){
                           weather.setName(parser.getValueAsString());
                       }
                   }
               }
               setResult("Synopticks in "+ weather.getBase() + " of " + weather.getName() + " city is silent...");

           } catch (Exception e) {

               e.printStackTrace();

           }
       }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}