package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.converter.UserConverter;
import com.example.ITSSBE.dto.UserDTO;
import com.example.ITSSBE.entity.Role;
import com.example.ITSSBE.entity.User;
import com.example.ITSSBE.repository.IRoleRepo;
import com.example.ITSSBE.repository.IUserRepo;
import com.example.ITSSBE.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private IRoleRepo roleRepo;

    public UserDTO getUserDTO(UserDTO userDTO) {
        User user = userRepo.findByGmailAndPassword( userDTO.getGmail(), userDTO.getPassword());
        if( user == null) return null;
        return userConverter.toDTO(user);
    }

    public UserDTO getUserById(int id) {
        return userConverter.toDTO( userRepo.findFirstById(id));
    }


    public UserDTO addUser(UserDTO userDTO) {
        Role role = roleRepo.findByName(userDTO.getRole_name());
        User user = userConverter.toEntity(userDTO, role);
        User savedUser = userRepo.save(user);
        return userConverter.toDTO(savedUser);
    }
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    public List<UserDTO> getAllStaff() {
        List<User> staffs = userRepo.findByRole();
        return staffs.stream().map(staff -> userConverter.toDTO(staff)).collect(Collectors.toList());
    }

    public List<UserDTO> getAllCustomers() {
        List<User> customers = userRepo.findCustomers();
        return customers.stream().map(customer -> userConverter.toDTO(customer)).collect(Collectors.toList());
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User tmp = userRepo.findFirstById(userDTO.getId());
        if (tmp == null)
            return null;
        Role role = roleRepo.findFirstByRoleId(userDTO.getRole_id());
        User user = userConverter.toEntity(userDTO, role);
        return userConverter.toDTO(userRepo.save(user));
    }
}
