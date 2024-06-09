package com.example.ITSSBE.converter;

import com.example.ITSSBE.dto.RegisterDTO;
import com.example.ITSSBE.entity.Package;
import com.example.ITSSBE.entity.Register;
import com.example.ITSSBE.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterConverter {
    @Autowired
    private ModelMapper modelMapper;
    public RegisterDTO toDTO(Register register) {
        if( register == null)
            return null;
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setId(register.getId());        registerDTO.setId(register.getId());
        registerDTO.setPrice(register.getPrice());
        registerDTO.setCreated_at(register.getCreated_at());
        registerDTO.setMy_package_id(register.getMy_package().getId());
        registerDTO.setMy_package_name(register.getMy_package().getName());
        registerDTO.setPrice(register.getMy_package().getPrice());
        registerDTO.setRegister_by_id(register.getRegister_by().getId());
        registerDTO.setRegister_by_name(register.getRegister_by().getFirst_name() + " " + register.getRegister_by().getLast_name());
        registerDTO.setTrainer_id(register.getTrainer().getId());
        registerDTO.setTrainer_name(register.getTrainer().getFirst_name() + " " + register.getTrainer().getLast_name());
        registerDTO.setCustomer_id(register.getCustomer().getId());
        registerDTO.setCustomer_name( register.getCustomer().getFirst_name()+ " " + register.getCustomer().getLast_name());
        registerDTO.setGmail(register.getCustomer().getGmail());
        return registerDTO;
    }

    public Register toEntity(RegisterDTO registerDTO, Package pa, User register_by, User trainer, User customer){
        Register register = modelMapper.map(registerDTO, Register.class);
        register.setRegister_by(register_by);
        register.setTrainer(trainer);
        register.setMy_package(pa);
        register.setCustomer(customer);
        return register;
    }
}
