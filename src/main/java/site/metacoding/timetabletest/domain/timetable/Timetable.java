package site.metacoding.timetabletest.domain.timetable;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.timetabletest.domain.course.Course;
import site.metacoding.timetabletest.domain.professor.Professor;
import site.metacoding.timetabletest.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "courseId")
    @ManyToOne
    private Course course; // courseId

    @JoinColumn(name = "professorId")
    @ManyToOne
    private Professor professor; // professorId

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user; // userId
    private String grade; // 학점

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedBy
    private LocalDateTime updateDate;
}
