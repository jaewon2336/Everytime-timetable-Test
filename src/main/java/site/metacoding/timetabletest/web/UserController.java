package site.metacoding.timetabletest.web;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // 권한비교
    @GetMapping("/admin/main")
    public String mainAdmin() {
        // 세션의 role 비교
        return "/admin/main";
    }

    // 회원가입
    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/joinForm";
    }

    @PostMapping("/join")
    public String join(User user) {

        if (user.getUsername().equals("admin")) {
            user.setRole("admin");
        }

        userService.회원가입(user);
        return "redirect:/login-form";
    }

    // 로그인
    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User userEntity = userService.로그인(user);

        if (userEntity.getRole().equals("admin")) {
            userEntity.setRole("admin");
            session.setAttribute("principal", userEntity);
            // admin일 경우 관리자페이지 열어주기
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } else {
            session.setAttribute("principal", userEntity); // 세션에 저장
            // user일 경우 테이블페이지 열어주기
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }

    }

}
