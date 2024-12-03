package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.*;

public class Facade {
    public String getAttributeValueFromJson(String urlString, String attribute) throws IllegalArgumentException, IOException {
        String json = getJsonFromUrl(urlString);
        return extractValueFromJson(json, attribute);
    }

    private String getJsonFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            connection.disconnect();
        }
    }

    private String extractValueFromJson(String json, String attribute) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            Object value = jsonObject.get(attribute);
            return value.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse JSON response: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        try {
            String url = "https://api.chucknorris.io/jokes/random";
            System.out.println(facade.getAttributeValueFromJson(url, "value"));
            String url2 = "https://api.fxratesapi.com/latest";
            System.out.println(facade.getAttributeValueFromJson(url2, "rates"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
