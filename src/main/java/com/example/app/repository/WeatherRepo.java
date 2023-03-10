package com.example.app.repository;

import com.example.app.entity.WeatherEntity;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepo extends CrudRepository<WeatherEntity, Long> {
}
