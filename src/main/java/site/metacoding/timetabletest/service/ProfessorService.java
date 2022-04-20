package site.metacoding.timetabletest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.timetabletest.domain.professor.Professor;
import site.metacoding.timetabletest.domain.professor.ProfessorRepository;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor 교수찾기(String name) {
        Optional<Professor> professorOp = professorRepository.findByName(name);
        if (professorOp.isPresent()) {
            return professorOp.get();
        } else {
            return null;
        }
    }
}
