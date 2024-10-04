package com.webperside.courseerpbackend.services.security;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.properties.security.SecurityProperties;
import com.webperside.courseerpbackend.services.base.TokenGenerator;
import com.webperside.courseerpbackend.services.base.TokenReader;
import com.webperside.courseerpbackend.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;


@Slf4j
@Component
@RequiredArgsConstructor
public class AccessTokenManager implements TokenGenerator<User>, TokenReader<Claims> {

    private final SecurityProperties securityProperties;

    // RSA
    @Override
    public String generate(User obj) {

        Claims claims = Jwts.claims();
        claims.put("email", obj.getEmail());
        //

        Date now = new Date();
        Date expiration = new Date(now.getTime() + securityProperties.getJwt().getRefreshTokenValidityTime());


        return Jwts.builder()
                .setSubject(String.valueOf(obj.getId()))
                .setIssuedAt(now)
                .setExpiration(expiration)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public Claims read(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }
}
