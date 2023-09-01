package com.cursojava.workshop.repositories;

import com.cursojava.workshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
