package org.budgetmate.user.service;

import java.util.Optional;

import org.budgetmate.common.jwt.JwtUtil;
import org.budgetmate.user.dto.LoginRequest;
import org.budgetmate.user.dto.SignupRequest;
import org.budgetmate.user.entity.User;
import org.budgetmate.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(SignupRequest request) {
        // 이메일 중복 체크
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 비밀번호 암호화
        user.setUserName(request.getUserName());

        return userRepository.save(user);
    }


    public String loginUser(LoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
        	return jwtUtil.createToken(user.get().getEmail(), "USER");
        } else {
            throw new RuntimeException("로그인 실패: 잘못된 이메일 또는 비밀번호");
        }
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }

}
