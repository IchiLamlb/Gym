package com.example.ITSSBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ep_category")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class EpCategory {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @Column( name = "name")
    private String name;
}
