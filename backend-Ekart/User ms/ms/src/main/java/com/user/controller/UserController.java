package com.user.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDto;
import com.user.service.UserService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService service;
    
    @PostMapping(value="/add")
    public ResponseEntity<UserDto> addDetails(@RequestBody UserDto user){
    	UserDto userDto=service.addData(user);
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDto);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<UserDto> getDetails(@PathVariable("id") int id){
    	UserDto user=service.getUser(id);
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    } 
    @PutMapping(value="/put")
    public ResponseEntity<String> updateDetails(@RequestBody UserDto user){
    	service.updateData(user);
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body("updated successfully");
    }
    @GetMapping(value="/all")
    public ResponseEntity<List<UserDto>> getAllusers(){
    	List<UserDto> users=service.fetchAllUsers();
    	return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
