package com.example.m_paridarshan.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    // Secure random key - store in config/env in production
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token validity: 1 hour
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims) // ✅ Stores all employee data
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // ✅ Non-deprecated
                .compact();
    }



    public static String generateUserToken(String username) {
        return Jwts.builder()
                .setSubject(username)                 // payload: sub
                .setIssuedAt(new Date())               // payload: iat
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // payload: exp
                .signWith(SECRET_KEY)                  // header: alg
                .compact();
    }
}
