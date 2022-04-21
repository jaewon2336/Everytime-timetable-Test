package site.metacoding.timetabletest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.course.CourseRepository;
import site.metacoding.timetabletest.domain.professor.Professor;
import site.metacoding.timetabletest.domain.professor.ProfessorRepository;
import site.metacoding.timetabletest.domain.timetable.Timetable;
import site.metacoding.timetabletest.domain.timetable.TimetableRepository;
import site.metacoding.timetabletest.domain.user.User;
import site.metacoding.timetabletest.web.dto.TimetableReqDto;
import site.metacoding.timetabletest.web.dto.TimetableResDto;

@RequiredArgsConstructor
@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;

    public void 시간표등록(TimetableReqDto timetableReqDto, User principal) {
        Course courseEntity = null;
        Professor professorEntity = null;

        Optional<Course> courseOp = courseRepository.findByName(timetableReqDto.getCourseName());
        if (courseOp.isPresent()) {
            courseEntity = courseOp.get();
        }

        Optional<Professor> professorOp = professorRepository.findByName(timetableReqDto.getProfessorName());
        if (professorOp.isPresent()) {
            professorEntity = professorOp.get();
        }

        Timetable timetable = timetableReqDto.toEntity(courseEntity, professorEntity, principal);
        timetableRepository.save(timetable);
    }

    public TimetableResDto 시간표가져오기() {
        // course 찾고 professor 찾아서 모델에 담아주기
        List<Course> courses = courseRepository.findAll();
        List<Professor> professors = professorRepository.findAll();

        TimetableResDto timetableResDto = new TimetableResDto();
        timetableResDto.setCourses(courses);
        timetableResDto.setProfessors(professors);
        return timetableResDto;
    }

}
