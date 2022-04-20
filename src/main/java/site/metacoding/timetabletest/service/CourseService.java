package site.metacoding.timetabletest.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.course.CourseRepository;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public void 강의등록(Course course) {
        courseRepository.save(course);

        System.out.println("================" + course);
    }

}
