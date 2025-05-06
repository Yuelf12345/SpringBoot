package com.example.yue.service;


import com.example.yue.entity.User;
import com.example.yue.entity.dto.UserDTO;

public interface UserService {

    User addUser(UserDTO user);
}
