package com.example.salonmanager.repository;

import com.example.salonmanager.dto.CategoryDTO;
import com.example.salonmanager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query("select new com.example.salonmanager.dto.CategoryDTO(c.id, c.name, c.type, c.image) from Category c")
    Set<CategoryDTO> findAllCategories();
}
