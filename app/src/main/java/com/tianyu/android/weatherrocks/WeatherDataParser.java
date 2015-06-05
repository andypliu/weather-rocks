package com.tianyu.android.weatherrocks;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by andy on 5/30/15.
 */
public class WeatherDataParser {
        private static String LOG_TAG = WeatherDataParser.class.getSimpleName();
        /**
         * Given a string of the form returned by the api call:
         * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
         * retrieve the maximum temperature for the day indicated by dayIndex
         * (Note: 0-indexed, so 0 would refer to the first day).
         */
        public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
                throws JSONException {
            // TODO: add parsing code here

            JSONObject jObj = new JSONObject(weatherJsonStr);
            JSONArray jArr = jObj.getJSONArray("list");
            double max = -1;
            if (dayIndex <= jArr.length()) {
                JSONObject obj = jArr.getJSONObject(dayIndex);
                JSONObject tempObj= obj.getJSONObject("temp");
                max = tempObj.getDouble("max");
                Log.v(LOG_TAG, "Max: " + max);
            }
            return max;
        }

}
