package site.metacoding.timetabletest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.course.CourseRepository;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> 강의목록() {
        return courseRepository.findAll();
    }

    @Transactional
    public void 강의등록(Course course) {
        courseRepository.save(course);
    }
}