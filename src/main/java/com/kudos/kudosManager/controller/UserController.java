package com.kudos.kudosManager.controller;

import com.kudos.kudosManager.entity.ProjectEntity;
import com.kudos.kudosManager.entity.UserEntity;
import com.kudos.kudosManager.model.User;
import com.kudos.kudosManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    /*
    @GetMapping("/users/manager/{managerId}/projects/")

    //UI Request Url : http://localhost:8080/users/manager/1/search?projectStatus=COMPLETED&techStack=Java
    @GetMapping("/users/manager/{managerId}/search")
    public List<ProjectEntity> searchProject(@PathVariable Long managerId,@RequestParam String projectStatus, )
    */

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/users", consumes = {"application/json"})
    public ResponseEntity<UserEntity> createUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<UserEntity> updateUser(@RequestBody User user) throws Exception {

        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{lastName}")
    public List<UserEntity> getAllUsers(@PathVariable String lastName) {
        return userService.findByLastName(lastName);
    }

    @GetMapping(value = "/leaderboard")
    public List<UserEntity> getNameByKudos() {

        return userService.findAllOrderByKudosAsc();
    }


    @PutMapping(value = "/projectHistory/{id} ")
    public ResponseEntity<UserEntity> setUserStatus(@PathVariable int id){
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }



}
