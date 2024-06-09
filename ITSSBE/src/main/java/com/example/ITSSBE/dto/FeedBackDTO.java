package com.example.ITSSBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDTO {
    private int id;
    private Date created_at;
    private String content;
    private int user_id;    
    private boolean is_deleted;
    private int parent_feedback_id;
}
