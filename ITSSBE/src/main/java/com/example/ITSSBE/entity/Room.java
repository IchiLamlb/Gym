package com.example.ITSSBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table( name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;
    @Column( name = "name")
    private String name;
    @Column( name = "address")
    private String address;
    @Column( name = "acreage")
    private int acreage;
    @Column( name = "is_deleted")
    private boolean is_deleted;
}
