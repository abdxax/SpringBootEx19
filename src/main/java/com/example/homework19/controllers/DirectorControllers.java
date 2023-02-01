package com.example.homework19.controllers;

import com.example.homework19.models.Director;
import com.example.homework19.services.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vq/director")
@RequiredArgsConstructor
public class DirectorControllers {
    private final DirectorService directorService;
@GetMapping("/getAll")
    public List<Director> getAll(){
        return directorService.getAll();
    }
    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody @Valid Director director){
    directorService.addItem(director);
    return ResponseEntity.status(200).body("Added Done");
    }
@PutMapping("/update/{id}")
    public ResponseEntity updateItem(@PathVariable Integer id,@RequestBody @Valid Director director){
          Boolean res= directorService.updateDircotre(id,director);
          if(!res){
              return ResponseEntity.status(400).body("The id is not correct ");
          }
          return ResponseEntity.status(200).body("Update Done");
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteItem(@PathVariable Integer id){
        Boolean res= directorService.deleteDir(id);
        if(!res){
            return ResponseEntity.status(400).body("The id is not correct ");
        }
        return ResponseEntity.status(200).body("Delete Done");
    }

}
