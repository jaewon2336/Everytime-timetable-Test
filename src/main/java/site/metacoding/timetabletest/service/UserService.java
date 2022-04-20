package site.metacoding.timetabletest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.user.User;
import site.metacoding.timetabletest.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void 회원가입(User user) {
        userRepository.save(user);
    }

    public User 로그인(User user) {
        Optional<User> userOp = userRepository.mLogin(user.getUsername(), user.getPassword());
        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new RuntimeException("없는사용자입니다.");
        }

    }

}
