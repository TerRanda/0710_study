package com.tj.edu.training.shinsunyoung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tj.edu.training.shinsunyoung.config.jwt.JwtFactory;
import com.tj.edu.training.shinsunyoung.config.jwt.JwtProperties;
import com.tj.edu.training.shinsunyoung.model.RefreshToken;
import com.tj.edu.training.shinsunyoung.model.User;
import com.tj.edu.training.shinsunyoung.model.dto.CreateAccessTokenRequestByRefreshToken;
import com.tj.edu.training.shinsunyoung.repository.RefreshTokenRepository;
import com.tj.edu.training.shinsunyoung.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TokenApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper om;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    JwtProperties jwtProperties;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @DisplayName("createNewAccessTokenByRefreshToken() 테스트")
    @Test
    void createNewAccessTokenByRefreshTokenTest1() throws Exception {
        // given
        String url = "/api/token";
        // 테스트 유저 데이터 생성
        User testUser = userRepository.save(User.builder()
                .email("user1@abc.com")
                .password("abcd")
                .build());
        // 테스트 refresh토큰 생성
        String refreshToken = JwtFactory.builder()
                .claims(Map.of("id", testUser.getId()))
                .build()
                .createToken(jwtProperties);
        refreshTokenRepository.save(new RefreshToken(testUser.getId(), refreshToken));

        CreateAccessTokenRequestByRefreshToken request = new CreateAccessTokenRequestByRefreshToken();
        request.setRefreshToken(refreshToken);
        final String requestBodyJson = om.writeValueAsString(request);

        ResultActions resultActions = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBodyJson));

        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.accessToken").isNotEmpty());
    }
}