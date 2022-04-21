package site.metacoding.timetabletest.web.dto.timetable;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.professor.Professor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimetableResDto {
    private List<Course> courses;
    private List<Professor> professors;
}
