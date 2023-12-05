package com.crud.dio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dio.demo.dto.UserDTO;
import com.crud.dio.demo.model.UserModel;
import com.crud.dio.demo.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public UserModel getUser (Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> 
           new Exception("ID de usuario nao encontrado: " + id));
    }

    public UserModel createUser (UserDTO userDTO) {
        UserModel userModel = UserModel.builder()
            .name(userDTO.getName())
            .email(userDTO.getEmail())
            .build();
        return userRepository.save(userModel);
    }
    
    public UserModel updateById (Long id, UserDTO userDTO ) throws Exception {
        UserModel userModel =  userRepository.findById(id).orElseThrow(() -> 
           new Exception("ID de usuario nao encontrado: " + id));
        
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        return userRepository.save(userModel);
    }

    public UserModel deleteById (Long id, UserDTO userDTO) throws Exception {
        UserModel userModel =  userRepository.findById(id).orElseThrow(() -> 
           new Exception("ID de usuario nao encontrado: " + id));

           userRepository.delete(userModel);
           return userModel;
    }

}
