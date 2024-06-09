package com.example.ITSSBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FeedBack {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;
    @Column( name = "content")
    private String content;
    @Column( name = "created_at")
    private Date created_at;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "user")
    private User by_user;
    @Column( name = "is_deleted")
    private boolean is_deleted;
    @Column( name = "parent_feedback_id")
    private int parent_feedback_id;
}
