package com.example.ITSSBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EquipmentDTO {
    private int id;
    private String name;
    private Date purchase_date;
    private int price;
    private int warranty_period;
    private int category_id;
    private String category_name;
    private int room_id;
    private boolean is_deleted;

}
