package com.example.practice74;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class StudentRepository {
    @Getter
    private List<Student> students;

    public StudentRepository() {
        this(new ArrayList<Student>());
    }

    public List<Student> findAll() {
        return this.students;
    }
}
