package telran.java2022.student.dao;

import telran.java2022.student.model.Student;

import java.util.Optional;

public interface StudentRepository{

    Student save(Student student);
    Optional<Student> findById(int id);
    void deleteById(int id);



}
