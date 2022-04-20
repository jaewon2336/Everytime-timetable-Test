package site.metacoding.timetabletest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.professor.Professor;
import site.metacoding.timetabletest.service.CourseService;
import site.metacoding.timetabletest.service.ProfessorService;
import site.metacoding.timetabletest.web.dto.AddCourseReqDto;

@RequiredArgsConstructor
@Controller
public class CourseController {

    private final CourseService courseService;
    private final ProfessorService professorService;

    @PostMapping("/admin/add-course")
    public String addCourse(AddCourseReqDto addCourseReqDto) {

        Professor professorEntity = professorService.교수찾기(addCourseReqDto.getProfessor());
        Integer time = addCourseReqDto.getEndTime() - addCourseReqDto.getStartTime();

        courseService.강의등록(addCourseReqDto.toEntity(time, professorEntity));

        return "redirect:/admin/course-list";
    }

}
