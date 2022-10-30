package telran.java2022.student.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java2022.student.dto.ScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;
import telran.java2022.student.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
//    @Autowired
    final StudentService studentService;

//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @PostMapping("/student")
    public  Boolean addStudent(@RequestBody StudentCreateDto studentCreateDto){
        return studentService.addStudent(studentCreateDto);

    }

    @GetMapping("/student/{id}")
    public StudentDto findStudent (@PathVariable Integer id){
        return studentService.findStudent(id);
    }


    @DeleteMapping("/student/{id}")
    public StudentDto removeStudent(@PathVariable Integer id) {
        return studentService.removeStudent(id);
    }

    @PutMapping("/student/{id}")
    public StudentCreateDto editStudent(@PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto) {
        return studentService.updateStudent(id, studentUpdateDto);
    }

    @PutMapping("/score/student/{id}")
    public boolean addScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
        return studentService.addScore(id, scoreDto);
    }

    @GetMapping("/students/name/{name}")
    public List<StudentDto> findStudentsByName(@PathVariable String name) {
        return studentService.findStudentsByName(name);
    }

    @PostMapping("/quantity/students")
    public long studentsNamesQuantity(@RequestBody List<String> names) {
        return studentService.getStudentsNamesQuantity(names);
    }

    @GetMapping("/students/exam/{exam}/minscore/{score}")
    public List<StudentDto> studentsByExamScore(@PathVariable String exam,
                                                @PathVariable Integer score) {
        return studentService.getStudentsByExamScore(exam, score);
    }

}
