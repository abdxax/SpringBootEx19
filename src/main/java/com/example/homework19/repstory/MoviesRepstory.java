package com.example.homework19.repstory;

import com.example.homework19.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepstory extends JpaRepository<Movie,Integer> {
  Movie findByIdEquals(Integer id);
  Movie findByName(String name);
  List<Movie> findByDirectorIDEquals(Integer id);
  List<Movie> findByRatingGreaterThanEqual(Integer ratin);
  List<Movie> findByGenre(String genre);
}
