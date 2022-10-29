package telran.java2022.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import telran.java2022.student.dao.StudentRepository;
import telran.java2022.student.dto.AddScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;
import telran.java2022.student.model.Student;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public Boolean addStudent(StudentCreateDto studentCreateDto) {
        if (studentRepository.findById(studentCreateDto.getId()).isPresent()){
            return false;
        }
        Student student = new Student(studentCreateDto.getId(),
                studentCreateDto.getName(), studentCreateDto.getPassword());
        studentRepository.save(student);
        return true;
    }

    @Override
    public StudentDto findStudent(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);


        return student == null ? null : StudentDto.builder().id(student.getId())
                .name(student.getName())
                .scores(student.getScores())
                .build();
    }

    @Override
    public StudentDto removeStudent(Integer id) {
        if (studentRepository.findById(id).isEmpty()) {
            return null;
        }
        Student student = studentRepository.findById(id).orElse(null);
        studentRepository.deleteById(id);
        return StudentDto.builder().id(student.getId())
                .name(student.getName())
                .scores(student.getScores())
                .build();
    }

    @Override
    public StudentCreateDto updateStudent(Integer id, StudentUpdateDto studentUpdateDto) {
        return null;
    }

    @Override
    public Boolean addScore(Integer id, AddScoreDto scoreDto) {
        return null;
    }

    @Override
    public List<StudentDto> findStudentsByName(String name) {
        return null;
    }

    @Override
    public Long getStudentsNamesQuantity(List<String> names) {
        return null;
    }

    @Override
    public List<StudentDto> getStudentsByExamScore(String exam, Integer score) {
        return null;
    }
}
