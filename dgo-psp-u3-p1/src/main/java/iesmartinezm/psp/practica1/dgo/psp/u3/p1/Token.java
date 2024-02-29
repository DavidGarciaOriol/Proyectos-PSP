package iesmartinezm.psp.practica1.dgo.psp.u3.p1;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

public class Token {

    private static final String SECRET_KEY = "my_secret_key_laskhdflkashdj9802374923847"; // Clave secreta para firmar el token
    private static final int EXPIRATION_TIME_MINUTES = 30; // Tiempo de expiración del token en minutos

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", "JuegoAdivinarNumero");
        claims.put("exp", new Date(System.currentTimeMillis() + (EXPIRATION_TIME_MINUTES * 60 * 1000)));
        claims.put("iat", new Date());
        claims.put("user", userName);
        claims.put("ip_user", getIPAddress());

        return Jwts.builder()
                .addClaims(claims)
                .signWith(generateKey())
                .compact();
    }

    private static SecretKey generateKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public Claims verifyToken(String jwt) {
        return Jwts.parser()
                .setSigningKey(generateKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private String getIPAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
}