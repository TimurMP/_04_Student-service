package telran.java2022.student.dao;

import telran.java2022.student.model.Student;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class StudentRepositoryImpl implements StudentRepository {

    Map<Integer, Student> students = new ConcurrentHashMap<>();

    @Override
    public Student save(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Optional<Student>  findById(int id) {
        return Optional.ofNullable(students.get(id)) ;
    }

    @Override
    public void deleteById(int id) {
        students.remove(id);

    }
}
