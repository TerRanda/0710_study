package com.tj.edu.training.shinsunyoung.service;

import com.tj.edu.training.shinsunyoung.config.jwt.TokenProvider;
import com.tj.edu.training.shinsunyoung.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(User user) {
        return tokenProvider.generatedToken(user, Duration.ofHours(2));
    }
    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if(!tokenProvider.validJwtToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generatedToken(user, Duration.ofHours(2));
    }
}
