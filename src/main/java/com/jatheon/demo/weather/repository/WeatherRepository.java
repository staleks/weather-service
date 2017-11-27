package com.jatheon.demo.weather.repository;

import com.jatheon.demo.weather.model.Weather;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends PagingAndSortingRepository<Weather, Long> {

    /**
     * @param destinationId
     * @return
     */
    List<Weather> findByDestinationId(Long destinationId);

    /**
     * @param destinationId
     * @param destinationId
     * @param startDate
     * @param endDate
     * @return
     */
    List<Weather> findByDestinationIdAndWeatherDateBetween(Long destinationId, LocalDate startDate, LocalDate endDate);

}
