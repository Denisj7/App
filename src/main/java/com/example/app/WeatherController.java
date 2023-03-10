package com.example.app;

import com.example.app.entity.WeatherEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    //@Autowired
    //private WeatherEntity WeatherEntity;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    public WeatherController(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }
    @RequestMapping(value="/town", method=RequestMethod.GET, produces="application/json")
    public JsonNode TownWeather(@RequestParam("town") String town)  {
        try {
            RestTemplate Weather = new RestTemplate();

            String URLGetLatLon = "https://api.openweathermap.org/geo/1.0/direct?q="+town+"&limit=5&appid=ebd40b85c61f79b63b1613c4b326ad4e";
            ResponseEntity<String> Response = Weather.getForEntity(URLGetLatLon, String.class);

            JsonNode root = objectMapper.readTree(Response.getBody());
            String URLGetWeather = "https://api.openweathermap.org/data/2.5/weather?lat="
                    +root.get(0).path("lon").asText()+"&lon="+ root.get(0).path("lat").asText()+"&appid=ebd40b85c61f79b63b1613c4b326ad4e";

            Response = Weather.getForEntity(URLGetWeather, String.class);
            root = objectMapper.readTree(Response.getBody());

            return root.path("main");
        } catch (JsonProcessingException e){
            throw new RuntimeException("ERROR ON PARSING JSON", e);
        }
    }

    @RequestMapping(value="/towns", method=RequestMethod.GET, produces="application/json")
    public JsonNode TownsNames()  {

        return null;
    }

    @PostMapping(value="/post")
    public JsonNode AddTown(@RequestBody WeatherEntity town)  {

        return null;
    }



    //public interface TaskScheduler {
    //    ScheduledFuture scheduleWithFixedDelay(Runnable task, Date startTime, long delay);

    //}


}
