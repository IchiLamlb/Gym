package com.example.ITSSBE.dto;

import com.example.ITSSBE.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String first_name;
    private String last_name;
    private Date birth;
    private String gender;
    private String gmail;
    private String password;
    private String avatar;
    private Boolean is_deleted;
    private int role_id;
    private String role_name;
    private String phone;
}
