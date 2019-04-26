package com.videodasy.AssetManager.Dao;

import org.springframework.data.repository.CrudRepository;

import com.videodasy.AssetManager.domain.User;

public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
}
