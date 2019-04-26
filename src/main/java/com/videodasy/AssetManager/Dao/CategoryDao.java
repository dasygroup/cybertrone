package com.videodasy.AssetManager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videodasy.AssetManager.domain.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
