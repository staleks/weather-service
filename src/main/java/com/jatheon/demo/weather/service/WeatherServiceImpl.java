package com.jatheon.demo.weather.service;

import com.jatheon.demo.weather.model.Weather;
import com.jatheon.demo.weather.model.WeatherType;
import com.jatheon.demo.weather.model.dto.WeatherDTO;
import com.jatheon.demo.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<WeatherDTO> findByDestination(final Long destinationId) {
        return mapFromList(weatherRepository.findByDestinationId(destinationId));
    }

    @Override
    public List<WeatherDTO> findByDestinationAndBetweenDates(final Long destinationId, final LocalDate startDate,
                                                             final LocalDate endDate) {
        return mapFromList(weatherRepository.findByDestinationIdAndWeatherDateBetween(destinationId, startDate, endDate));
    }

    /**
     * @param weather
     * @return
     */
    private WeatherDTO mapFromEntity(Weather weather) {
        return new WeatherDTO(weather.getId(), weather.getDestinationId(), weather.getWeatherDate(), WeatherType.weatherTypeById(weather.getWeatherType().getId()).getWeatherName(), weather.getTemperature());
    }

    private List<WeatherDTO> mapFromList(List<Weather> weatherList) {
        List<WeatherDTO> result = new ArrayList<>();
        for (Weather weatherItem: weatherList) {
            result.add(mapFromEntity(weatherItem));
        }
        return result;
    }


}
