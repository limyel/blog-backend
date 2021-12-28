package com.limyel.blog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {

    @Value("${blog.jwt.secret}")
    private String secret;

    @Value("${blog.jwt.expiration}")
    private Long expiration;

    public String generateJWT(Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                // 过期时间
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Map<String, Object> parseJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody();
        Map<String, Object> result = new HashMap<>();
        for (String key: claims.keySet()) {
            result.put(key, claims.get(key));
        }

        return result;
    }

    public Long parseId(String jwt) {
        Map<String, Object> map = parseJWT(jwt);
        return map.get("id") == null? null: (long) map.get("id");
    }

    /**
     * 生成过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}
