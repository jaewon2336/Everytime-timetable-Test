package site.metacoding.timetabletest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.professor.Professor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCourseReqDto {

    private String name;
    private Integer point;
    private String professor;
    private String classroom;
    private String weekday;
    private Integer startTime;
    private Integer endTime;

    public Course toEntity(Integer time, Professor professor) {
        Course course = new Course();
        course.setName(name);
        course.setPoint(point);
        course.setProfessor(professor);
        course.setWeekday(weekday);
        course.setClassroom(classroom);
        course.setTime(time);
        return course;
    }

}
