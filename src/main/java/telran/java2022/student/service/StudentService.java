package telran.java2022.student.service;

import telran.java2022.student.dto.AddScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;

import java.util.List;

public interface StudentService {

    Boolean addStudent(StudentCreateDto studentCreateDto);
    StudentDto findStudent(Integer id);

    StudentDto removeStudent(Integer id);

    StudentDto updateStudent(Integer id);

    Boolean addScore(Integer id, AddScoreDto scoreDto);

    List<StudentDto> findStudentByName(String name);

    Integer StudentsQuantity (List<String> studentNames );

    List<StudentDto> findStudentByMinScore(String exam, Integer score);






}
