package telran.java2022.student.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter


public class Student {
    int id;
    @Setter
    String name;
    @Setter
    String password;
    Map<String, Integer> scores;

    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        scores = new HashMap<>();
    }

    public boolean addScore(String exam, int score){
        return scores.put(exam, score) == null;
    }

}
