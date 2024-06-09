package com.example.ITSSBE.service;

import com.example.ITSSBE.dto.EquipmentDTO;

import java.util.List;

public interface IEquipmentService {
    List<EquipmentDTO> getAllEquipments();
    EquipmentDTO getEquipment( int id);
    EquipmentDTO addEquipment(EquipmentDTO equipmentDTO);
    EquipmentDTO changeEquipment(EquipmentDTO equipmentDTO, int id);
    EquipmentDTO deleteEquipment( int id);
}
