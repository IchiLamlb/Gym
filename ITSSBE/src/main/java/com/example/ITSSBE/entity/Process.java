package com.example.ITSSBE.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "process")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Process {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;
    @Column( name = "created_at")
    private Date created_at;
    @Column( name = "content")
    private String content;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "register")
    private Register register;

}
