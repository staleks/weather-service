package com.jatheon.demo.weather.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;

public class WeatherDTO {

    private Long id;
    private Long destinationId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate weatherDate;
    private String weatherType;
    private Integer temperature;

    public WeatherDTO(Long id, Long destinationId, LocalDate weatherDate, String weatherType, Integer temperature) {
        this.id = id;
        this.destinationId = destinationId;
        this.weatherDate = weatherDate;
        this.weatherType = weatherType;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public LocalDate getWeatherDate() {
        return weatherDate;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getWeatherType() {
        return weatherType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
