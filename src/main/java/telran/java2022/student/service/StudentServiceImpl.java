package telran.java2022.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.java2022.student.dao.StudentRepository;
import telran.java2022.student.dto.ScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;
import telran.java2022.student.dto.exceptions.StudentNotFoundException;
import telran.java2022.student.model.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

//    @Autowired
    final StudentRepository studentRepository;

//    @Autowired
//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

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
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));


        return StudentDto.builder().id(student.getId())
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
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null) {
            return null;
        }
        student.setName(studentUpdateDto.getName());
        student.setPassword(studentUpdateDto.getPassword());
        studentRepository.save(student);
        return StudentCreateDto.builder()
                .id(id)
                .name(student.getName())
                .password(student.getPassword())
                .build();

    }

    @Override
    public Boolean addScore(Integer id, ScoreDto scoreDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        boolean res = student.addScore(scoreDto.getExamName(), scoreDto.getScore());

        studentRepository.save(student);
        return res;

    }

    @Override
    public List<StudentDto> findStudentsByName(String name) {
        return studentRepository.findByNameIgnoreCase(name)
                .map(s -> new StudentDto(s.getId(), s.getName(), s.getScores()))
                .collect(Collectors.toList());
    }

    @Override
    public Long getStudentsNamesQuantity(List<String> names) {
        return studentRepository.countByNameInIgnoreCase(names);
    }

    @Override
    public List<StudentDto> getStudentsByExamScore(String exam, Integer score) {
        return studentRepository.findByExamAndScoreGreaterThan(exam, score)
                .map(s -> new StudentDto(s.getId(), s.getName(), s.getScores()))
                .collect(Collectors.toList());
    }



}
