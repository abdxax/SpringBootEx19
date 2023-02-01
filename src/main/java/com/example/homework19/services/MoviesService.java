package com.example.homework19.services;

import com.example.homework19.handling.ApiException;
import com.example.homework19.models.Director;
import com.example.homework19.models.Movie;
import com.example.homework19.repstory.DirectorRepstory;
import com.example.homework19.repstory.MoviesRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesService {
    private final MoviesRepstory moviesRepstory;
    private final DirectorRepstory directorRepstory;
    public Movie addItem(Movie movie){
        moviesRepstory.save(movie);
        return movie;
    }

    public List<Movie> getAll(){
        return moviesRepstory.findAll();
    }

    public Boolean updateMovie(Integer id,Movie movie){
        Movie d=moviesRepstory.findByIdEquals(id);
        if(d==null){
            return false;
        }
        d.setName(movie.getName());
        d.setRating(movie.getRating());
        d.setDuration(movie.getDuration());
        d.setGenre(movie.getGenre());

        moviesRepstory.save(d);
        return true;
    }

    public Movie findByName(String title){
        return moviesRepstory.findByName(title);
    }

    public Director DurtfindById(Integer id){
        return directorRepstory.findByIdEquals(id);
    }

    public List<Movie> findByDirectorIDEquals(Integer id){
        return moviesRepstory.findByDirectorIDEquals(id);
    }
    public List<Movie> findByRatingGreaterThanEqual(int ra){
        return moviesRepstory.findByRatingGreaterThanEqual(ra);
    }

    public List<Movie> findByGenre(String g){
        return moviesRepstory.findByGenre(g);
    }

    public Boolean deleteMovie(Integer id){
        Movie d=moviesRepstory.findByIdEquals(id);
        if(d==null){
            return false;
        }

        moviesRepstory.delete(d);
        return true;
    }
}
