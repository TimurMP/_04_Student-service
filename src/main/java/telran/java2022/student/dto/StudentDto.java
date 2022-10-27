package telran.java2022.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StudentDto {

    Integer id;
    String name;
    Map<String, Integer> scores;


}
