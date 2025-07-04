package com.example.basic_project.global.jwt;

import com.zaxxer.hikari.pool.HikariProxyCallableStatement;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${JWT_SECRET_KEY}")
    private String secretKey;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    /**
     * 토큰 만들기
     */
    public String createJwt(Long memberId) {

        String subject = memberId.toString(); // 사용자 준비
        Date now = new Date();                // 현재시간
        Date expiration = new Date(now.getTime() + 1000 * 60); // 만료시간 설정 1분뒤

        return Jwts.builder()
                .subject(subject)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getKey())
                .compact();
    }

    /**
     * 토큰을 검증하고 memberId 를 반환합니다.
     */
    public Long verifyToken(String token) {
        try {
            SecretKey Key = Keys.hmacShaKeyFor(secretKey.getBytes());

            Claims claims = Jwts.parser()
                    .verifyWith(Key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String subject = claims.getSubject();
            // String value1  = (String) claims.get("key1"); // 커스텀하게 설정한 요소 추출

            return Long.parseLong(subject);
        } catch (JwtException e) {
            throw new RuntimeException("JWT 검증 실패", e);
        }
    }
}
