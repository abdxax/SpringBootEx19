package com.example.homework19.repstory;

import com.example.homework19.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepstory extends JpaRepository<Director,Integer> {

    Director findByName(String name);
    Director findByIdEquals(Integer id);


}
