package com.videodasy.AssetManager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.videodasy.AssetManager.domain.Department;

public interface DepartmentDao extends JpaRepository<Department, Long> {

}
