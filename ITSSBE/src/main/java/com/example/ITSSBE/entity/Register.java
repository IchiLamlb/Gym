package com.example.ITSSBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "register")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;
    @Column( name = "created_at")
    private Date created_at;
    @Column( name = "is_deleted")
    private Boolean is_deleted;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "package")
    private Package my_package;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "register_by")
    private User register_by;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "trainer")
    private User trainer;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "customer")
    private User customer;
    @Column( name =  "price")
    private int price;

}
