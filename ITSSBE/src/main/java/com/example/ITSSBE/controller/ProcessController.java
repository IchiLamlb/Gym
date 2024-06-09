package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.ProcessDTO;
import com.example.ITSSBE.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    private IProcessService processService;
    @GetMapping("/")
    public ResponseEntity<Object> getAllProcess(){
        return new ResponseEntity<>( processService.getAllProcess() , HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> addProcess(@RequestBody ProcessDTO processDTO){
        return new ResponseEntity<>(processService.addProcess(processDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProcessByRegisterId(@PathVariable int id){
        return new ResponseEntity<>(processService.getProcessByRegisterId(id), HttpStatus.OK);
    }

}
