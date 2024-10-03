package com.sreedhar3210.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable             //means this class can be extended by others as a variable or column in a data table.
public class RestaurantDto {

    private String title;
    
    @Column(length = 1000)
    private List<String>images;

}
