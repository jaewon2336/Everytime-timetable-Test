package site.metacoding.timetabletest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeTableController {
    @GetMapping("/admin")
    public String mainAdmin() {
        // 세션의 role 비교
        return "/admin";
    }

    @GetMapping("/user")
    public String mainUser() {
        return "/timetable";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "/joinForm";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "/loginForm";
    }

}
