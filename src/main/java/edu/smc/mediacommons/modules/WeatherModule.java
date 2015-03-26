package edu.smc.mediacommons.modules;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import lombok.Getter;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.JSONTokener;

@Getter
public class WeatherModule {
    
    private final JSONObject response;

    public WeatherModule(String search) {
        InputStream is = null;
        JSONObject result = null;
        
        String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
        String query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + search + "\")";
        
        try {
            String fullUrlStr = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=json";
            URL fullUrl = new URL(fullUrlStr);
            is = fullUrl.openStream();

            JSONTokener tok = new JSONTokener(is);
            result = new JSONObject(tok);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        response = result;
    }
}