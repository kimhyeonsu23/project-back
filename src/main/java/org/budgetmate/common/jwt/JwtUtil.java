package org.budgetmate.common.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

    @Value("${JWT_SECRET}") // .env에서 주입
    private String secretKeyString;

    private SecretKey key;
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secretKeyString.getBytes(StandardCharsets.UTF_8));
        System.out.println("🔐 JWT 키 초기화 완료: " + secretKeyString);
    }
 
    public String createToken(String email) {
        return createToken(email, "USER");
    }

    public String createToken(String email, String role) {
        if (email == null || role == null) {
            throw new IllegalArgumentException("email 또는 role이 null일 수 없습니다.");
        }

        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }


    public String getEmailFromToken(String token) {
        String email = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
        System.out.println("📨 토큰에서 추출한 이메일: " + email);
        return email;
    }


    public boolean validateToken(String token) {
        try {
            System.out.println("🔍 토큰 검증 시작: " + token);
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
            System.out.println("✅ 유효한 토큰입니다.");
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("❌ Invalid JWT: " + e.getMessage());
            return false;
        }
    }
    public String getRoleFromToken(String token) {
        try {
            String role = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .get("role", String.class);
            System.out.println("🎭 토큰에서 추출한 역할: " + role);
            return role;
        } catch (Exception e) {
            System.out.println("⚠️ 역할 추출 실패: " + e.getMessage());
            return null;
        }
    }


}
