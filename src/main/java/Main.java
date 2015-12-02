import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.util.*;

/**
 * Created by nikol on 23.11.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        JSONObject jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("http://gdata.youtube.com/feeds/api/videos/SIFL9qfmu5U?alt=json"))).nextValue();
//        System.out.println(jo.getString("version"));
//        WebTarget webTarget = client.target("http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0");
//        try {
//        JSONObject json = new JSONObject(readUrl("http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0"));
//
//        String title = (String) json.get("title");
//
//
//    } catch (JSONException e) {
//        e.printStackTrace();
//    }
//        String carJson =
//                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

//        JsonFactory factory = new JsonFactory();
//        JsonParser parser  = factory.createParser(responseEntity);
//
//        while(!parser.isClosed()){
//            JsonToken jsonToken = parser.nextToken();
//
//            System.out.println("jsonToken = " + jsonToken);
//        }

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0";
//

        String responseEntity = ClientBuilder.newClient().target(url).path("").request().get(String.class);

        System.out.println(responseEntity);
        Map <String,String> weatherMap = new Map<String, String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String put(String key, String value) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends String> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<String> values() {
                return null;
            }

            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }
        };

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(responseEntity);
        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();

            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();
                jsonToken = parser.nextToken();
                weatherMap.put(fieldName, parser.getValueAsString());
                System.out.println(fieldName + " " + parser.getValueAsString());
            }
        }
        System.out.println("----------------------------------");
        String s = weatherMap.get("term_min");
        System.out.println(s);

        JSONObject obj = new JSONObject(responseEntity);

        List<String> list = new ArrayList<String>();
        JSONArray array = obj.getJSONArray("weather");
        for(int i = 0 ; i < array.length() ; i++){
            list.add(array.getJSONObject(i).getString("main"));
            System.out.println("main = "+ array.getJSONObject(i).getString("description"));
        }
    }
}