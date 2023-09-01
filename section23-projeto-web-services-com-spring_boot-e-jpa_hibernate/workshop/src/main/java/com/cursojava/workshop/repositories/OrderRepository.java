package com.cursojava.workshop.repositories;

import com.cursojava.workshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
