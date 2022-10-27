package telran.java2022.student.controller;


import org.springframework.web.bind.annotation.*;
import telran.java2022.student.dto.AddScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    StudentService studentService;

    @PostMapping("/student")
    public  Boolean addStudent(@RequestBody StudentCreateDto studentCreateDto){
        return  studentService.addStudent(studentCreateDto);

    }

    @GetMapping("/student/{id}")
    public StudentDto findStudent (@PathVariable Integer id){
        return studentService.findStudent(id);
    }


    @DeleteMapping("/student/{id}")
    public StudentDto removeStudent (@PathVariable Integer id){
        return studentService.removeStudent(id);
    }


    @PutMapping("/student/{id}")
    public StudentDto updateStudent(@PathVariable Integer id){
        return studentService.updateStudent(id);
    }

    @PutMapping("/score/student/{id}")
    public Boolean addScore(@PathVariable Integer id, @RequestBody AddScoreDto score){
        return studentService.addScore(id, score);
    }

    @GetMapping("/students/name/{name}")
    public List<StudentDto> findStudentByName (@PathVariable String name){
        return studentService.findStudentByName(name);
    }

    @PostMapping("/quantity/students")
    public Integer StudentsQuantity (@RequestBody List<String> studentNames ){
        return studentService.StudentsQuantity(studentNames);
    }

    @GetMapping("/students/exam/{exam}/minscore/{score}")
    public  List<StudentDto> findStudentByMinScore(@PathVariable String exam, @PathVariable Integer score ){
        return studentService.findStudentByMinScore(exam, score);
    }

}
