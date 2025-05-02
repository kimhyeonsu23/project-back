package org.budgetmate.user.controller;

import java.util.Map;

import org.budgetmate.user.dto.LoginRequest;
import org.budgetmate.user.dto.SignupRequest;
import org.budgetmate.user.entity.User;
import org.budgetmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest request) {
        User user = userService.registerUser(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            String token = userService.loginUser(request);
            return ResponseEntity.ok().body(Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("로그인 실패");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyInfo(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.getUserByEmail(email);  // ✅ 서비스 계층 호출
        return ResponseEntity.ok(user);
    }

}
