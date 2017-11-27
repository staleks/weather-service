package com.jatheon.demo.weather.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_weather")
public class Weather extends AbstractPersistable<Long> {

    @Column(name = "destination_id")
    private Long destinationId;

    @Column(name = "weather_date")
    private LocalDate weatherDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "weather_type")
    private WeatherType weatherType;

    private Integer temperature;

    public Weather() {

    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(final Long destinationId) {
        this.destinationId = destinationId;
    }

    public LocalDate getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(final LocalDate weatherDate) {
        this.weatherDate = weatherDate;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(final Integer temperature) {
        this.temperature = temperature;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(final WeatherType weatherType) {
        this.weatherType = weatherType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
