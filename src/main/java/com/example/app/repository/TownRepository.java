package com.example.app.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.app.model.Town;

@Repository
public interface TownRepository extends CrudRepository<Town, Long> {

}