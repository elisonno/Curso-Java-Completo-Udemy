package com.cursojava.workshop.services;

import com.cursojava.workshop.entities.User;
import com.cursojava.workshop.repositories.UserRepository;
import com.cursojava.workshop.services.exceptions.DatabaseException;
import com.cursojava.workshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            if (findById(id) != null) {
                repository.deleteById(id);
                System.out.println("Entrou");
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        User entity = repository.getReferenceById(id);
        updadeData(entity, user);
        return repository.save(entity);
    }

    public void updadeData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
