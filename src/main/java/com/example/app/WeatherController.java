package com.example.app;

import com.example.app.model.Town; //Denisj
import com.example.app.repository.TownRepository;
import com.example.app.service.ITownService;
import com.example.app.service.TownService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    //private TownService townService;
    private ITownService townService;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    public WeatherController(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    @GetMapping("/weather/towns")
    public String findTowns(Model model) {
        var towns = (List<Town>) townService.findAll();
        model.addAttribute("town", towns);
        System.out.println(Arrays.toString(towns.toArray()));
        return "towns";
    }

/*
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

    @RequestMapping(value="/townget", method=RequestMethod.GET)
    public ResponseEntity GetTownName(@RequestParam String town)  {

        try {
            return ResponseEntity.ok(weatherService.GetTownName(town));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибкат");
        }
    }

    @PostMapping(value="/post")
    public ResponseEntity AddTown(@RequestBody WeatherEntity town)  {
        try {
            weatherService.AddTown(town);
            return  ResponseEntity.ok("Город успешно добавлен");
        }catch (TownAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

*/

    //public interface TaskScheduler {
    //    ScheduledFuture scheduleWithFixedDelay(Runnable task, Date startTime, long delay);

    //}


}
