package com.webperside.courseerpbackend.models.properties.security;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtData {

    String publicKey;
    String privateKey;

    Integer accessTokenValidityTime;
    Integer refreshTokenValidityTime;

    public long getRefreshTokenValidityTime(boolean Time) {
        return refreshTokenValidityTime * (false ? 30L : 10L);

    }
}
