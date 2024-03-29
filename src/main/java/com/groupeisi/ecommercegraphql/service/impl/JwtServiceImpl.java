package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.User;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import com.groupeisi.ecommercegraphql.service.IUserService;
import com.groupeisi.ecommercegraphql.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Slf4j
@Service
@AllArgsConstructor
public class JwtServiceImpl implements JwtService {
    private IUserService  userService;
    private UserMapper userMapper;
    private static final long EXPIRATION_TIME = 60 * 30 * 1000;

    private static final String SECRET= "ZSalJ/4FuU+EIzCfLdqbo3FdPR4Zd10vWKh6gaxLhWk=";
    /**
     * @param username  is Email
     * @return genearate Token which is a Map<String,String> of {"bearer ":token}
     * @throws EntityNotFoundException if user not found
     */
    @Override
    public Map<String, String> generate(String username) {
        UserDto userDto = userService.findByEmail(username).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
        User user = userMapper.toUserEntity(userDto);
        return this.generateToken(user);
    }

    private Map<String,String> generateToken(User user){
        final long currentTimeMillis = System.currentTimeMillis();

        final Map<String,String> claims = Map.of(
                "nom", user.getUsername(),
                "iat", String.valueOf(new Date(currentTimeMillis + EXPIRATION_TIME))
        );
        String bearer = Jwts.builder()
                .setIssuedAt(new Date(currentTimeMillis))
                .setSubject(user.getUsername())
                .setExpiration(new Date(currentTimeMillis + EXPIRATION_TIME))
                .setClaims(claims)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        return Map.of("bearer ", bearer);
    }


    private Key getKey() {
        byte[] decodeJwt = Decoders.BASE64.decode(SECRET);
        log.info("decodeJwt : {}", SECRET);
        return Keys.hmacShaKeyFor(decodeJwt);
    }
}
