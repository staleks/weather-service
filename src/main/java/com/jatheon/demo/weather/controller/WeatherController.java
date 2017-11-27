package com.jatheon.demo.weather.controller;

import com.jatheon.demo.weather.model.dto.WeatherDTO;
import com.jatheon.demo.weather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class WeatherController {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{destinationId}")
    public ResponseEntity<List<WeatherDTO>> findWeatherForDestination(@PathVariable("destinationId") Long destinationId,
                                                                      @RequestParam(name = "startDate", required = false) String startDate,
                                                                      @RequestParam(name = "endDate", required = false) String endDate) {
        if (startDate == null && endDate == null) {
            LOG.info("clean call no dates");
            return new ResponseEntity<List<WeatherDTO>>(weatherService.findByDestination(destinationId), HttpStatus.OK);
        } else {
            if (startDate == null && endDate != null) {
                return new ResponseEntity<List<WeatherDTO>>(HttpStatus.BAD_REQUEST);
            } else if (startDate != null && endDate == null) {
                return new ResponseEntity<List<WeatherDTO>>(HttpStatus.BAD_REQUEST);
            } else {
                LOG.info("given startDate and endDate");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
                LocalDate endLocalDate = LocalDate.parse(endDate, formatter);
                return new ResponseEntity<List<WeatherDTO>>(weatherService.findByDestinationAndBetweenDates(destinationId, startLocalDate, endLocalDate), HttpStatus.OK);
            }
        }
    }



}
