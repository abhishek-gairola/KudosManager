package com.kudos.kudosManager.service;

import com.kudos.kudosManager.entity.UserEntity;
import com.kudos.kudosManager.mapper.UserServiceMapper;
import com.kudos.kudosManager.model.User;
import com.kudos.kudosManager.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = repository.findAll();
        return Optional.ofNullable(users).orElse(Collections.emptyList());

    }

    public UserEntity getUserById(Long id) throws Exception {
        Optional<UserEntity> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }

    public UserEntity createUser(User user) throws Exception {
        return repository.save(UserServiceMapper.getUserEntity(user));
    }

    public UserEntity updateUser(User user) throws Exception {
        if (repository.existsById(user.getId())) {
            return repository.save(UserServiceMapper.getUserEntity(user));
        } else {
            throw new Exception("Record not found");
        }
    }

    public void deleteUserById(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }

    public List<UserEntity> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }


}
