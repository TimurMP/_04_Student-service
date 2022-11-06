package telran.java2022.student.dto.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(int id) {
        super("Student with ID " + id + " not found");
    }



}
