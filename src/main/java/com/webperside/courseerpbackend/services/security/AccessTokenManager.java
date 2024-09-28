package com.webperside.courseerpbackend.services.security;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.services.base.TokenGenerator;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;

@CommonsLog
@Slf4j
@RequiredArgsConstructor
public class AccessTokenManager implements TokenGenerator<User> {

    // RSA
    @Override
    public String generate(User obj) {
        return Jwts
                .builder()
                .setSubject(null)
                .setIssuedAt(null)
                .setExpiration(null)
                .setClaims(null)
//                .signWith(null)
                .compact();
    }
}
