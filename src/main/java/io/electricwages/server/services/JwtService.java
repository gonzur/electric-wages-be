package io.electricwages.server.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@PropertySource("classpath:secret.properties")
public class JwtService {
    @Value("${JWT.secret}")
    String secret;
    Algorithm algo;

    @PostConstruct
    public void init(){
       algo = Algorithm.HMAC256(secret);
    }
    public String createJWT(String username, String role) {
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("role", role);
        var cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1);

        return JWT.create().withIssuer("electric-wages")
                .withPayload(body)
                .withExpiresAt(cal.getTime())
                .withIssuedAt(new Date())
                .sign(algo);
    }

    public void validateJWT(String jwt) {

    }
}
