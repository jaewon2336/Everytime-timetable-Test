package site.metacoding.timetabletest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.professor.Professor;
import site.metacoding.timetabletest.service.CourseService;
import site.metacoding.timetabletest.service.ProfessorService;
import site.metacoding.timetabletest.web.dto.course.AddCourseReqDto;

@RequiredArgsConstructor
@Controller
public class CourseController {

    private final CourseService courseService;
    private final ProfessorService professorService;

    @GetMapping("/admin/course")
    public String addCourse() {
        return "/admin/addCourse";
    }

    @GetMapping("/admin/course-list")
    public String courseList(Model model) {
        List<Course> courses = courseService.강의목록();
        model.addAttribute("courses", courses);
        return "/admin/courseList";
    }

    @PostMapping("/admin/add-course")
    public String addCourse(AddCourseReqDto addCourseReqDto, Model model) {

        Professor professorEntity = professorService.교수찾기(addCourseReqDto.getProfessor());

        courseService.강의등록(addCourseReqDto.toEntity(professorEntity));

        return "redirect:/admin/course-list";
    }

}
