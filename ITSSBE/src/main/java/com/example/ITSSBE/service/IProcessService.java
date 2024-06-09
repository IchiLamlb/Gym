package com.example.ITSSBE.service;

import com.example.ITSSBE.dto.ProcessDTO;

import java.util.List;

public interface IProcessService {
    List<ProcessDTO> getAllProcess();
    ProcessDTO addProcess(ProcessDTO processDTO);
    List<ProcessDTO> getProcessByRegisterId(int id);
}
