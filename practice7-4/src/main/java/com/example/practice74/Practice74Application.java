package com.example.practice74;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class Practice74Application {

    public static void main(String[] args) {

        SpringApplication.run(Practice74Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            List<Student> students = IntStream.range(1, 4)
                    .mapToObj(i -> new Student(UUID.randomUUID(), "Student #" + i,
                            "Student #" + i + " description"))
                    .collect(Collectors.toList());
            studentRepository.getStudents().addAll(students);
        };
    }

}
