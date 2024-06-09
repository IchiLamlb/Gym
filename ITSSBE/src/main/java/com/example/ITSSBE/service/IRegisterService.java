package com.example.ITSSBE.service;

import com.example.ITSSBE.dto.RegisterDTO;

import java.util.List;

public interface IRegisterService {
    List<RegisterDTO> getRegisters();
    RegisterDTO addRegister(RegisterDTO registerDTO);
    RegisterDTO changeRegister(RegisterDTO registerDTO, int id);
    RegisterDTO getRegister(int id);
    void deleteRegister(int id);
    List<RegisterDTO> getRegisterByCustomerId(int customerId);
}
