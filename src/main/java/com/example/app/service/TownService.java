package com.example.app.service;

import com.example.app.model.Town;
import com.example.app.repository.TownRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownService implements ITownService {
    @Autowired
    private TownRepository townRepository;

    @Override
    public List<Town> findAll() {
        var towns = (List<Town>) townRepository.findAll();
        System.out.print(towns);
        return towns;
    }
}
