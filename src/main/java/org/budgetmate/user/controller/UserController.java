package org.budgetmate.user.controller;

import org.budgetmate.user.entity.User;
import org.budgetmate.user.repository.UserRepository;
import org.budgetmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")

public class UserController {

	@Autowired
    private UserRepository userRepository;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
	    System.out.println("Received user data: " + user); // 유저 데이터 로그 찍기
	    User savedUser = userRepository.save(user);  // DB에 저장
	    return ResponseEntity.ok(savedUser);  // 저장된 데이터를 반환
	}

}

