package com.github.mosinpower.kubercrud.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
