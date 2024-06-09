package com.example.ITSSBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private int id;
    private Date created_at;
    private int my_package_id;
    private String my_package_name;
    private int price;
    private int register_by_id;
    private Boolean is_registered;
    private String register_by_name;
    private int trainer_id;
    private String trainer_name;

    private int customer_id;
    private String customer_name; 
    private String gmail;   

}
