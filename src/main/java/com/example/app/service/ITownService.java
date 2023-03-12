package com.example.app.service;

import com.example.app.model.Town;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ITownService {
    List<Town> findAll();
}
