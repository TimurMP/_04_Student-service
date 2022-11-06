package telran.java2022.student.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import telran.java2022.student.model.Student;

import java.util.List;
import java.util.stream.Stream;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Stream<Student> findByNameIgnoreCase(String name);

    long countByNameInIgnoreCase(List<String> names);


    @Query("{'scores.?0':  {$gt: ?1}}")
    Stream<Student> findByExamAndScoreGreaterThan(String exam, int score);






//    Student save(Student student);
//
//    Optional<Student> findById(int id);
//
//    void deleteById(int id);

//    void updateStudent(Integer id, Student student);
//
//    void addScore(Integer id, Student student);
//
//    List<Student> findStudentsByName(String name);
//
//    Long studentsQuantity(List<String> names);
//
//    List<Student> findStudentsByScore(String exam, Integer score);

//    Iterable<Student> findAll();


}
