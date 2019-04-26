package com.videodasy.AssetManager.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.videodasy.AssetManager.domain.Staff;

public interface StaffDao extends JpaRepository<Staff, Long> {

	Staff findByStaffId(long staffid);
	
}
