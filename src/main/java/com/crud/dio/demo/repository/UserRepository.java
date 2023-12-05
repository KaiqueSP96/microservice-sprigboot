package com.crud.dio.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.dio.demo.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    
    
}