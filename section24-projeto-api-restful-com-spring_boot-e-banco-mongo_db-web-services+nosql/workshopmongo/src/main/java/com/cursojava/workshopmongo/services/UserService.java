package com.cursojava.workshopmongo.services;

import com.cursojava.workshopmongo.domain.User;
import com.cursojava.workshopmongo.dto.UserDTO;
import com.cursojava.workshopmongo.repository.UserRepository;
import com.cursojava.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

}
