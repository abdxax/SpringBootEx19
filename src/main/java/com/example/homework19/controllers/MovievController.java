package com.example.homework19.controllers;

import com.example.homework19.models.Director;
import com.example.homework19.models.Movie;
import com.example.homework19.services.DirectorService;
import com.example.homework19.services.MoviesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
public class MovievController {
    private final MoviesService moviesService;
    private final DirectorService directorService;
@GetMapping("/getAll")
    public List<Movie> getAll(){
        return moviesService.getAll();
    }
@PostMapping("addItem")
    public ResponseEntity addItem(@RequestBody @Valid Movie movie){
        moviesService.addItem(movie);
    return     ResponseEntity.status(200).body("Added Done");
    }

@PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Movie movie){
        Boolean m=moviesService.updateMovie(id,movie);
        if(!m){
            return ResponseEntity.status(400).body("The Id is not correct");
        }
        return ResponseEntity.status(200).body("Update Done");
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean m=moviesService.deleteMovie(id);
        if(!m){
            return ResponseEntity.status(400).body("The Id is not correct");
        }
        return ResponseEntity.status(200).body("delete Done");
    }
@GetMapping("/getTitle/{name}")
    public ResponseEntity getByTitle(@PathVariable String name){
    Movie m =moviesService.findByName(name);
          if(m==null){
              return  ResponseEntity.status(400).body("The name error");
          }
    return ResponseEntity.status(200).body(m);
    }
@GetMapping("/getduration/{name}")
    public ResponseEntity getduration(@PathVariable String name){
      Movie movie=moviesService.findByName(name);
    if(movie==null){
        return  ResponseEntity.status(400).body("The name error");
    }
      return ResponseEntity.status(200).body(movie.getDuration());
    }

    @GetMapping("/getDirecot/{name}")
    public ResponseEntity getDirec(@PathVariable String name){
        Movie movie=moviesService.findByName(name);
        if(movie==null){
            return  ResponseEntity.status(400).body("The name error");
        }
        Director d=moviesService.DurtfindById(movie.getDirectorID());
        return ResponseEntity.status(200).body(d.getName());
    }
@GetMapping("/getMoviesdirector/{name}")
    public ResponseEntity getMoviesdirector(@PathVariable String name){
      Director d=directorService.findByName(name);
      if(d==null){
          return ResponseEntity.status(400).body("The name not found");
      }
      List<Movie> movies=moviesService.findByDirectorIDEquals(d.getId());
      return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/getrate/{name}")
    public ResponseEntity getrate(@PathVariable String name){
        Movie movie=moviesService.findByName(name);
        if(movie==null){
            return  ResponseEntity.status(400).body("The name error");
        }

        return ResponseEntity.status(200).body(movie.getRating());
    }

    @GetMapping("/getMoviesrates/{rate}")
    public ResponseEntity getMoviesRate(@PathVariable Integer rate){

        List<Movie> movies=moviesService.findByRatingGreaterThanEqual(rate);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/getMoviesGan/{g}")
    public ResponseEntity getMoviesGan(@PathVariable String g){

        List<Movie> movies=moviesService.findByGenre(g);
        return ResponseEntity.status(200).body(movies);
    }

}
