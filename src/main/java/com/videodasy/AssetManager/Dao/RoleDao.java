package com.videodasy.AssetManager.Dao;

import org.springframework.data.repository.CrudRepository;

import com.videodasy.AssetManager.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}
