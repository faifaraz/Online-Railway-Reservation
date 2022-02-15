package com.example.SecurityUser.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SecurityUser.model.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
	
	UserModel findByusername(String username);

}
