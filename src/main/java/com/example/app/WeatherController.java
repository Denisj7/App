package com.example.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@RestController
public class WeatherController {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    public WeatherController(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }
    /*public interface WeatherRepository extends JpaRepository<WeatherRepository, String>{

    }

    @Autowired
    private WeatherRepository weatherRepo;

    @GetMapping("/test")
    public String listAll(Model model){
        List<WeatherRepository> listWeather = weatherRepo.findAll();
        model.addAttribute("listWeather", listWeather);

        return "weather";
    }*/
    @RequestMapping(value="/weather/town", method= RequestMethod.GET, produces="application/json")
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

    @RequestMapping(value="/weather/towns", method= RequestMethod.GET, produces="application/json")
    public int TownsNames()  {

        return 1;
    }



    //public interface TaskScheduler {
    //    ScheduledFuture scheduleWithFixedDelay(Runnable task, Date startTime, long delay);

    //}


}
