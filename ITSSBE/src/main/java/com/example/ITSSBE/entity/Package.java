package com.example.ITSSBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "package")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;
    @Column( name = "name")
    private String name;
    @Column( name = "price")
    private int price;
    @Column( name = "description")
    private String description;
    @Column( name = "is_deleted")
    private boolean is_deleted;
    @Column( name = "time")
    private int time;
}
