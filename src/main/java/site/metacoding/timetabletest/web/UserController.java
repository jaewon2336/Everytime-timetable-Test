package site.metacoding.timetabletest.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.user.User;
import site.metacoding.timetabletest.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/join")
    public String join(User user) {

        if (user.getUsername().equals("admin")) {
            user.setRole("admin");
        }

        userService.회원가입(user);
        return "redirect:/login-form";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User userEntity = userService.로그인(user);

        if (userEntity.getRole().equals("admin")) {
            userEntity.setRole("admin");
            session.setAttribute("principal", userEntity);
            return new ResponseEntity<>(0, HttpStatus.OK);
        }

        session.setAttribute("principal", userEntity); // 세션에 저장

        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}
