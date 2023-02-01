package com.example.homework19.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "the name can not be null")
    @Size(min = 3)
    private String name;
    @NotEmpty(message = "the genre can not be null")
    @Pattern(regexp = "Drama|Action|Comedy",message = "must be Drama|Action|Comedy")
    private String genre;
    @NotNull(message = "rating can be null")
    @Min(1)
    @Max(5)
    private int rating;
    @NotNull(message = "Can not be null")
    private String duration;
    private int directorID;

}
