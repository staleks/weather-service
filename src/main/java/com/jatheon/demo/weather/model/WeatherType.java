package com.jatheon.demo.weather.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum WeatherType {

    SUNNY(1, "Sunny"),
    MOSTLY_SUNNY(2, "Mostly sunny"),
    CLOUDY(3, "Cloudy"),
    RAINY(4, "Rainy"),
    WINDY(5, "Windy"),
    STORMY(6, "Stormy");

    private Integer id;
    private String weatherName;

    private static final Map<Integer, WeatherType> WEATHER_TYPES;

    static {
        Map<Integer, WeatherType> weatherTypes = new HashMap<>();
        for (WeatherType wt: WeatherType.values()) {
            weatherTypes.put(wt.getId(), wt);
        }
        WEATHER_TYPES = Collections.unmodifiableMap(weatherTypes);

    }

    private WeatherType(Integer id, String weatherName) {
        this.id = id;
        this.weatherName = weatherName;
    }

    public Integer getId() {
        return id;
    }

    public String getWeatherName() {
        return weatherName;
    }

    public static WeatherType weatherTypeById(Integer weatherTypeId) {
        return WEATHER_TYPES.get(weatherTypeId);
    }

}
