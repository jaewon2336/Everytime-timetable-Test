package site.metacoding.timetabletest.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.user.User;
import site.metacoding.timetabletest.service.TimetableService;
import site.metacoding.timetabletest.web.dto.TimetableReqDto;

@RequiredArgsConstructor
@Controller
public class TimeTableController {

    private final TimetableService timetableService;
    private final HttpSession session;

    @PostMapping("/user/{id}/timetable")
    public ResponseEntity<?> addTimetable(@PathVariable Integer id, @RequestBody TimetableReqDto timetableReqDto) {
        User principal = (User) session.getAttribute("principal");
        timetableService.시간표등록(timetableReqDto, principal);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }
}