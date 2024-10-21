package com.sreedhar3210.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sreedhar3210.dto.RestaurantDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id             // acts as a primary key.
    @GeneratedValue(strategy = GenerationType.AUTO)             //auto generates values for primary key.
    private Long Id;

    private String fullName;
    private String email; 
    private String password;
    private USER_ROLE role;

    @JsonIgnore                      //JsonIgnore doesn't include that particular variable while fetching data.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order>orders = new ArrayList<Order>();

    @ElementCollection
    private List<RestaurantDto>favorites = new ArrayList<>();

    //cascade = CascadeType.ALL will remove all the Related Addresses when User is Removed.
    //orphanRemoval = true will enable deletion of child records from parent.
    //in this case orphan removal allows us to remove the addresses
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();
}
