package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private static final String SECRET_KEY = "secretkey";
    private static final long TOKEN_VALIDITY_MILLIS = 1200000; // 20 minutes

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("authHeader: {}", authHeader);

        Map<String, String> map = new HashMap<>();
        map.put("token", "");

        String user = getUser(authHeader);
        String token = generateJwt(user);
        map.put("token", token);

        LOGGER.info("End");
        return map;
    }

    /**
     * Decodes the Base64 "Basic <credentials>" Authorization header value
     * and returns just the username portion (text before the colon).
     */
    private String getUser(String authHeader) {
        LOGGER.debug("getUser - authHeader: {}", authHeader);

        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes);

        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(":"));
        LOGGER.debug("getUser - user: {}", user);

        return user;
    }

    /**
     * Builds a signed JWT (HS256) for the given username, issued now and
     * expiring 20 minutes from now.
     */
    private String generateJwt(String user) {
        LOGGER.debug("generateJwt - user: {}", user);

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        // Set the token issue time as current time
        builder.setIssuedAt(new Date());
        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date((new Date()).getTime() + TOKEN_VALIDITY_MILLIS));
        builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY);
        String token = builder.compact();

        LOGGER.debug("generateJwt - token: {}", token);
        return token;
    }
}
