package site.metacoding.timetabletest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.professor.Professor;
import site.metacoding.timetabletest.service.ProfessorService;

@RequiredArgsConstructor
@Controller
public class professorController {

    private final ProfessorService professorService;

    @GetMapping("/admin/professor")
    public String addProfessor() {
        return "/admin/addProfessor";
    }

    @PostMapping("/admin/add-professor")
    public String addCourse(Professor professor) {

        professorService.교수등록(professor);

        return "redirect:/admin/professor-list";
    }

}
