package com.tj.edu.training.shinsunyoung.service;

import com.tj.edu.training.shinsunyoung.model.User;
import com.tj.edu.training.shinsunyoung.model.dto.AddUserRequest;
import com.tj.edu.training.shinsunyoung.model.dto.LoginRequest;
import com.tj.edu.training.shinsunyoung.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final TokenProvider tokenProvider;

    public Long register(AddUserRequest dto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return userRepository.save(
                User.builder()
                        .email(dto.getEmail())
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                        .build()).getId();
    }
    public User register(User user) {
        return userRepository.save(user);
    }
    public User login(LoginRequest loginRequest) {
        Optional<User> optUser = userRepository.findByEmail(loginRequest.getUsername());
        User user = optUser.get();

        //user가 있는지 여부 체크
        if (optUser.isEmpty())
            return null;

        user = optUser.get();
        // user가 있는지 여부 체크
//        if (!Objects.isNull(user)) {
//            // 0. 패스워드가 맞는지 비교
//            //   (1) 맞으면 1-2-3-4 실행
//            //   (2) 틀리면 user값을 null로 세팅
//            String encPwd = bCryptPasswordEncoder.encode(loginRequest.getPassword());
////            if (encPwd.equals(user.getPassword())) {
//            if (bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//                // 1. access토큰을 발급(tokenService.createNewAccessToken(user) 코드 사용)
//                String accessToken = tokenProvider.generatedToken(user, Duration.ofHours(2));
//                // 2. access토큰을 user java객체에 저장
//                user.setAccessToken(accessToken);
//                // 3. access토큰을 user db정보에 저장
//                userRepository.save(user);
//            }
//            // 4.(option) 해당 유저에 대한 role저장
//        }

        return user;
    }
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

}
