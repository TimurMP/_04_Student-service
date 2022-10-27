package telran.java2022.student.service;

import telran.java2022.student.dto.AddScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;

import java.util.List;

public interface StudentService {

    Boolean addStudent(StudentCreateDto studentCreateDto);
    StudentDto findStudent(Integer id);

    StudentDto removeStudent(Integer id);

    StudentCreateDto updateStudent(Integer id, StudentUpdateDto studentUpdateDto);

    Boolean addScore(Integer id, AddScoreDto scoreDto);

    List<StudentDto> findStudentsByName(String name);

    Long getStudentsNamesQuantity(List<String> names);

    List<StudentDto> getStudentsByExamScore(String exam, Integer score);






}
