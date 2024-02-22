/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmartinezm.psp.practica1.dgo.psp.u3.p1;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

/**
 *
 * @author ciclot
 */
public class Token {
    
    private static final String SECRET_KEY = "";
    private static final int EXPIRATION_TIME_MINUTES = 2;

    public String generateToken() {
        
        Map<String, Object> extraClaims = new HashMap<>();
        
        extraClaims.put("", "");
        
        Date currentDate = new Date(System.currentTimeMillis());
        Date expirationDate = new Date(currentDate.getTime() + (EXPIRATION_TIME_MINUTES * 60 * 1000));
        
        
        String miJwt = Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .subject("")
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .claims(extraClaims)
                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact();
        
        // Claims payload = verifyJwts(miJwt);
        
        return miJwt;
        
    }
    
    
    private static SecretKey generateKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
    
    public Claims verifyJwts(String jwt){
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
    
}
