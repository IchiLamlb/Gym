package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.converter.EquipmentConverter;
import com.example.ITSSBE.dto.EquipmentDTO;
import com.example.ITSSBE.entity.*;
import com.example.ITSSBE.repository.*;
import com.example.ITSSBE.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentService implements IEquipmentService {
    @Autowired
    private IEquipmentRepo equipmentRepo;
    @Autowired
    private EquipmentConverter equipmentConverter;
    @Autowired
    private IEpCategoryRepo epCategoryRepo;
    @Autowired
    private IRoomRepo roomRepo;

    public List<EquipmentDTO> getAllEquipments() {
        List<Equipment> equipments = equipmentRepo.findAll();
        return equipments.stream().map(equipment -> equipmentConverter.toDTO(equipment)).collect(Collectors.toList());

    }

    public EquipmentDTO getEquipment(int id) {
        return equipmentConverter.toDTO(equipmentRepo.findById(id));

    }

    public EquipmentDTO addEquipment(EquipmentDTO equipmentDTO) {
        EpCategory epCategory = epCategoryRepo.findByName( equipmentDTO.getCategory_name());
        Room room = roomRepo.findById(equipmentDTO.getRoom_id());
        if(epCategory == null){
            System.out.println("Chua co thiet bi nay");
            Equipment equipment = equipmentRepo.save(equipmentConverter.toEntity(equipmentDTO,epCategory,room));
            return equipmentConverter.toDTO(equipment);
        }
        return null;
    }
    public EquipmentDTO changeEquipment(EquipmentDTO equipmentDTO, int id) {
        Equipment equipment = equipmentRepo.findById(id);
        Room room = roomRepo.findById(equipmentDTO.getRoom_id());
        EpCategory category = epCategoryRepo.findById(equipmentDTO.getCategory_id());

        equipment.setRoom(room);
        equipment.setCategory(category);
        equipment.setPrice(equipmentDTO.getPrice());
        equipment.setPuchase_date(equipmentDTO.getPurchase_date());
        equipment.setName(equipmentDTO.getName());
        equipment.setWarranty_period(equipmentDTO.getWarranty_period());
        Equipment savedEquipment = equipmentRepo.save(equipment);
        return equipmentConverter.toDTO(savedEquipment);
    }
    public EquipmentDTO deleteEquipment(int id) {
        Equipment equipment = equipmentRepo.findById(id);
        equipment.set_deleted(true);
        Equipment savedEquipment = equipmentRepo.save(equipment);
        return equipmentConverter.toDTO(savedEquipment);
    }
}
