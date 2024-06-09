package com.example.ITSSBE.converter;

import com.example.ITSSBE.dto.EquipmentDTO;
import com.example.ITSSBE.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipmentConverter {
    @Autowired
    private ModelMapper modelMapper;
    public EquipmentDTO toDTO(Equipment equipment) {
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setId(equipment.getId());
        equipmentDTO.setName(equipment.getName());
        equipmentDTO.setPurchase_date(equipment.getPuchase_date());
        equipmentDTO.setPrice(equipment.getPrice());
        equipmentDTO.setWarranty_period(equipment.getWarranty_period());
        equipmentDTO.setCategory_id(equipment.getCategory().getId());
        equipmentDTO.setCategory_name(equipment.getCategory().getName());
        equipmentDTO.setRoom_id(equipment.getRoom().getId());
        return equipmentDTO;
    }

    public Equipment toEntity(EquipmentDTO equipmentDTO, EpCategory epCategory, Room room){
        Equipment equipment = new Equipment();
        equipment.setCategory(epCategory);
        equipment.setRoom(room);
        return equipment;
    }
}
