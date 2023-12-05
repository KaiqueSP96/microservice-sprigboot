package com.crud.dio.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dio.demo.dto.UserDTO;
import com.crud.dio.demo.model.UserModel;
import com.crud.dio.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Iterable<UserModel>> getUsers() throws Exception {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}") 
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
     public ResponseEntity<UserModel> create(@RequestBody @Valid UserDTO userDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body((userService.createUser(userDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update ( @RequestBody @Valid @PathVariable Long id, UserDTO userDto ) throws Exception {
        return ResponseEntity.ok(userService.updateById(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> delete ( @PathVariable Long id, UserDTO userDto ) throws Exception {
        return ResponseEntity.ok(userService.deleteById(id, userDto));
    }

}
