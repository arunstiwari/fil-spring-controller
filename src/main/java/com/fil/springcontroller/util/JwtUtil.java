package com.fil.springcontroller.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;

// @Component
public class JwtUtil {
//    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//    // Generate token
//    public String generateToken(String username, List<String> roles, int minutes) {
//        return Jwts.builder()
//                .claim("roles", roles)
//                .setSubject(username)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * minutes)) // 1 hour
//                .signWith(key)
//                .compact();
//    }
//
//    // Extract username
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build()
//                .parseClaimsJws(token).getBody().getSubject();
//    }
//
//    // Validate token
//    public boolean validateToken(String token, String username) {
//        return extractUsername(token).equals(username) &&
//                !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        Date exp = Jwts.parserBuilder().setSigningKey(key).build()
//                .parseClaimsJws(token).getBody().getExpiration();
//        return exp.before(new Date());
//    }
//
//    public Claims extractAllClaims(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build()
//                .parseClaimsJws(token).getBody();
//    }
}
