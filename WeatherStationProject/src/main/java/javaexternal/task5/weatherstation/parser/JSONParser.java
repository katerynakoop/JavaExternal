package javaexternal.task5.weatherstation.parser;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser extends Parser
{
    static final Logger logger = Logger.getLogger(JSONParser.class);
    @Override
    public void parse(String responseBody)
    {
        try
        {
            JSONObject jsonObjectMain = new JSONObject(responseBody).getJSONObject("main");
            temperature = jsonObjectMain.getFloat("temp");
            pressure = jsonObjectMain.getFloat("pressure");
            humidity = jsonObjectMain.getFloat("humidity");
            temp_min = jsonObjectMain.getFloat("temp_min");
            temp_max = jsonObjectMain.getFloat("temp_max");

            JSONObject jsonObjectWind = new JSONObject(responseBody).getJSONObject("wind");
            wind_speed = jsonObjectWind.getFloat("speed");
        }
        catch (JSONException e)
        {
            logger.error(e);
        }
    }
}
