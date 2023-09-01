package com.cursojava.workshop.repositories;

import com.cursojava.workshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
