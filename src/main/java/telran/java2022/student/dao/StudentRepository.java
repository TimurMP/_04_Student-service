package telran.java2022.student.dao;

import telran.java2022.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(int id);

    void deleteById(int id);

    void updateStudent(Integer id, Student student);

    void addScore(Integer id, Student student);

    List<Student> findStudentsByName(String name);

    Long studentsQuantity(List<String> names);

    List<Student> findStudentsByScore(String exam, Integer score);


}
