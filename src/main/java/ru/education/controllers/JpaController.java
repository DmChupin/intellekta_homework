package ru.education.controllers;

import org.springframework.web.bind.annotation.*;
import ru.education.entity.AcademicAdviser;
import ru.education.entity.Student;
import ru.education.jpa.AcademicAdviserRepository;
import ru.education.jpa.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/jpa")
public class JpaController {

    private final StudentRepository studentRepository;

    private final AcademicAdviserRepository academicAdviserRepository;

    public JpaController(StudentRepository studentRepository, AcademicAdviserRepository academicAdviserRepository) {
        this.studentRepository = studentRepository;
        this.academicAdviserRepository = academicAdviserRepository;
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable("id") Long id) {
        return  studentRepository.findById(id);
    }

    @PostMapping("/students")
    public Student addStudents(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/advisers")
    public List<AcademicAdviser> getAcademicAdvisers(){
        return  academicAdviserRepository.findAll();
    }

    @GetMapping("/advisers/{id}")
    public Optional<AcademicAdviser> getAcademicAdviset(@PathVariable("id") Long id) {
        return  academicAdviserRepository.findById(id);
    }

    @PostMapping("/advisers")
    public AcademicAdviser addAcademicAdviser(@RequestBody AcademicAdviser academicAdviser){
        return academicAdviserRepository.save(academicAdviser);
    }

}
