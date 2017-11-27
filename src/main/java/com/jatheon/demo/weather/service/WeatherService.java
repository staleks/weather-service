package com.jatheon.demo.weather.service;

import com.jatheon.demo.weather.model.dto.WeatherDTO;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService {

    /**
     * @param destinationId
     * @return
     */
    List<WeatherDTO> findByDestination(Long destinationId);

    /**
     * @param destinationId
     * @param startDate
     * @param endDate
     * @return
     */
    List<WeatherDTO> findByDestinationAndBetweenDates(Long destinationId, LocalDate startDate, LocalDate endDate);


}
