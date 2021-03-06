package site.metacoding.timetabletest.web.dto.timetable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.professor.Professor;
import site.metacoding.timetabletest.domain.timetable.Timetable;
import site.metacoding.timetabletest.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimetableReqDto {
    private Integer userId;
    private String courseName;
    private String professorName;
    private String weekday;
    private Integer startTime;
    private Integer endTime;
    private String classroom;

    public Timetable toEntity(Course course, Professor professor, User principal) {
        Timetable timetable = new Timetable();
        timetable.setCourse(course);
        timetable.setProfessor(professor);
        timetable.setUser(principal);

        return timetable;
    }
}
