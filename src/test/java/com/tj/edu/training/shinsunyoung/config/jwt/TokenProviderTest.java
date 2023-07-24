package com.tj.edu.training.shinsunyoung.config.jwt;

import com.tj.edu.training.shinsunyoung.model.User;
import com.tj.edu.training.shinsunyoung.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Duration;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserRepository userRepository;
    @DisplayName("generateToken 테스트")
    @Test
    void generateTokenTest1() {
        // 테스트 유저 데이터 생성
        User testUser = userRepository.save(User.builder()
                        .email("user1@abc.com")
                        .password("abcd")
                        .build());

        //when

        String token = tokenProvider.generatedToken(testUser, Duration.ofDays(14));
        System.out.println("------------------------generateToken: " + token);
        //then

        Long userId = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .get("id", Long.class);
        assertThat(userId).isEqualTo(testUser.getId());
    }
    @DisplayName("validJwtToken 테스트")
    @Test
    void validJwtTokenTest1() {
        //given
        // 테스트 유저 데이터 생성
        User testUser = userRepository.save(User.builder()
                .email("user1@abc.com")
                .password("abcd")
                .build());

       String token = tokenProvider.generatedToken(testUser, Duration.ofDays(14));
       //when
       boolean result = tokenProvider.validJwtToken(token);
       //then
       assertThat(result).isTrue();
    }
    @DisplayName("jwtFactory 테스트")
    @Test
    void jwtFactoryTest1() {
        String token = JwtFactory.builder()
                .subject("user@email.com")
                .build()
                .createToken(jwtProperties);

        //when
        Authentication authentication = tokenProvider.getAuthentication(token);
        String username = (((UserDetails)authentication.getPrincipal()).getUsername());
        String password = (((UserDetails)authentication.getPrincipal()).getPassword());
        List<GrantedAuthority> grantedAuthorityList  = ((UserDetails)authentication.getPrincipal()).getAuthorities().stream().collect(toList());
        grantedAuthorityList.forEach((authority) -> System.out.println("auth: " + authority.getAuthority()));
        //then
        assertThat(((UserDetails)authentication.getPrincipal()).getUsername()).isEqualTo("user@email.com");
    }
}