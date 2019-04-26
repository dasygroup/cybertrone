package com.videodasy.AssetManager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videodasy.AssetManager.domain.Asset;

public interface AssetDao extends JpaRepository<Asset, Long> {

}
