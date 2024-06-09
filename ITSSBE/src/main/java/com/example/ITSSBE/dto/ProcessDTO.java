package com.example.ITSSBE.dto;

import com.example.ITSSBE.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDTO {
    private int id;
    private Date created_at;
    private String content;
    private int register_id;
}
