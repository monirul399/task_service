package tech.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.example.project.exception.UserNotFoundException;
import tech.example.project.model.Student;
import tech.example.project.repo.StudentRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }

    // Update a student
    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    // Delete a student
    public void deleteStudent(Long id){
        studentRepo.deleteStudentById(id);
    }

    // Search a student by id
    public Student findStudentById(Long id){
        return studentRepo.findStudentById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
}
