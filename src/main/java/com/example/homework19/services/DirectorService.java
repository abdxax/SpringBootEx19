package com.example.homework19.services;

import com.example.homework19.handling.ApiException;
import com.example.homework19.models.Director;
import com.example.homework19.repstory.DirectorRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepstory directorRepstory;
    public Director addItem(Director director){
        directorRepstory.save(director);
        return director;
    }

    public List<Director> getAll(){
        return directorRepstory.findAll();
    }

    public Boolean updateDircotre(Integer id,Director director){
        Director d=directorRepstory.findByIdEquals(id);
        if(d==null){
            return false;
        }
        d.setName(director.getName());
        directorRepstory.save(d);
        return true;
    }

    public Boolean deleteDir(Integer id){
        Director d=directorRepstory.findByIdEquals(id);
        if(d==null){
            return false;
        }

        directorRepstory.delete(d);
        return true;
    }

    public Director findByName(String name){
        return directorRepstory.findByName(name);
    }

}
