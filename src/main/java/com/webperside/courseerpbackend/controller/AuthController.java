package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.dto.RefreshTokenDto;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.response.auth.LoginResponse;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import com.webperside.courseerpbackend.services.security.RefreshTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;


    @PostMapping("/login")
    public BaseResponse<LoginResponse> login() {

        User user = User.builder().email("cukur54@gmail.com").build();
        user.setId(1L);
        System.out.println("++");

        return BaseResponse.success(
                LoginResponse.builder()
                        .accessToken(accessTokenManager.generate(user))
                        .refreshToken(refreshTokenManager.generate(
                                        RefreshTokenDto.builder()
                                                .user(user)
                                                .rememberMe(true)
                                                .build()
                                )
                        )
                        .build()
        );
    }
}
