package tech.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.example.project.model.Student;

import java.util.Optional;

// This repository is for Student class and primary key is id
public interface StudentRepo extends JpaRepository<Student, Long> {
    void deleteStudentById(Long id);
    Optional<Student> findStudentById(Long id);
}
