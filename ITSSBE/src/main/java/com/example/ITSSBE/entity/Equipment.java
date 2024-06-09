package com.example.ITSSBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "equipment")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Equipment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;
    @Column( name = "name")
    private String name;
    @Column( name = "purchase_date")
    private Date puchase_date;
    @Column( name = "price")
    private int price;
    @Column( name = "warranty_period")
    private int warranty_period;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "category")
    private EpCategory category;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "room")
    private Room room;
    @Column( name = "is_deleted")
    private boolean is_deleted;
}
