package telran.java2022.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import telran.java2022.student.dao.StudentRepository;
import telran.java2022.student.dto.AddScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;
import telran.java2022.student.model.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public Boolean addStudent(StudentCreateDto studentCreateDto) {
        if (studentRepository.findById(studentCreateDto.getId()).isPresent()) {
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
        if (studentRepository.findById(id).isEmpty()) {
            return null;
        }
        Student student = new Student(id, studentUpdateDto.getName(), studentUpdateDto.getPassword());
        studentRepository.updateStudent(id, student);
        return StudentCreateDto.builder().id(student.getId())
                .name(student.getName())
                .password(student.getPassword())
                .build();

    }

    @Override
    public Boolean addScore(Integer id, AddScoreDto scoreDto) {
        if (studentRepository.findById(id).isEmpty()) {
            return false;
        }
        Student student = studentRepository.findById(id).orElse(null);
        student.addScore(scoreDto.getExamName(), scoreDto.getScore());
        studentRepository.updateStudent(id, student);
        return true;
    }

    @Override
    public List<StudentDto> findStudentsByName(String name) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> students = studentRepository.findStudentsByName(name);
        for (Student student : students) {
            StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getScores());
            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }

    @Override
    public Long getStudentsNamesQuantity(List<String> names) {
        return studentRepository.studentsQuantity(names);
    }

    @Override
    public List<StudentDto> getStudentsByExamScore(String exam, Integer score) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> students = studentRepository.findStudentsByScore(exam, score);
        for (Student student : students) {
            StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getScores());
            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }
}
