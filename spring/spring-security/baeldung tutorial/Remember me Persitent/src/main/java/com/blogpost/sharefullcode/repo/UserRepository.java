package com.blogpost.sharefullcode.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogpost.sharefullcode.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
	UserModel findByusername(String username);
}
