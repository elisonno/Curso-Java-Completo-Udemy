package com.cursojava.workshop.repositories;

import com.cursojava.workshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
