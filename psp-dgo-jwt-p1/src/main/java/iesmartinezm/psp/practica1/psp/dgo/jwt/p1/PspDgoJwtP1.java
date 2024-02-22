/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package iesmartinezm.psp.practica1.psp.dgo.jwt.p1;

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
public class PspDgoJwtP1 {
    
    private static final String SECRET_KEY_NO_SEGURA = "Clave No Segura";
    private static final String SECRET_KEY = "Esto si es una clave segura 12345$";
    private static final int EXPIRATION_TIME_MINUTES = 2;

    public static void main(String[] args) {
        
        Map<String, Object> extraClaims = new HashMap<>();
        
        extraClaims.put("apellidos", "garcía oriol");
        extraClaims.put("nombre", "David");
        extraClaims.put("Curso", "2 DAM");
        
        Date currentDate = new Date(System.currentTimeMillis());
        Date expirationDate = new Date(currentDate.getTime() + (EXPIRATION_TIME_MINUTES * 60 * 1000));
        
        
        String miJwt = Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .subject("David")
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .claims(extraClaims)
                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact();
        
        System.out.println(miJwt);
        
        Claims payload = verifyJwts(miJwt);
        
        System.out.println(payload.get("nombre"));
        
    }
    
    
    private static SecretKey generateKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
    
    private static Claims verifyJwts(String jwt){
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
}
