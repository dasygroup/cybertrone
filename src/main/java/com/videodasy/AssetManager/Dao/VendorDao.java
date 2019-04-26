package com.videodasy.AssetManager.Dao;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.videodasy.AssetManager.domain.Vendor;

public interface VendorDao extends JpaRepository<Vendor, Long> {


}
