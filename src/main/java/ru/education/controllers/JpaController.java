package ru.education.controllers;

import org.springframework.web.bind.annotation.*;
import ru.education.entity.AcademicAdviserJpa;
import ru.education.entity.StudentJpa;
import ru.education.jpa.AcademicAdviserJpaRepository;
import ru.education.jpa.StudentJpaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/jpa")
public class JpaController {

    private final StudentJpaRepository studentJpaRepository;

    private final AcademicAdviserJpaRepository academicAdviserJpaRepository;

    public JpaController(StudentJpaRepository studentJpaRepository, AcademicAdviserJpaRepository academicAdviserJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
        this.academicAdviserJpaRepository = academicAdviserJpaRepository;
    }


    @GetMapping("/students")
    public List<StudentJpa> getStudents(){
        return studentJpaRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<StudentJpa> getStudent(@PathVariable("id") Long id) {
        return  studentJpaRepository.findById(id);
    }

    @PostMapping("/students")
    public StudentJpa addStudents(@RequestBody StudentJpa studentJpa){
        return studentJpaRepository.save(studentJpa);
    }

    @GetMapping("/advisers")
    public List<AcademicAdviserJpa> getAcademicAdvisers(){
        return  academicAdviserJpaRepository.findAll();
    }

    @GetMapping("/advisers/{id}")
    public Optional<AcademicAdviserJpa> getAcademicAdviset(@PathVariable("id") Long id) {
        return  academicAdviserJpaRepository.findById(id);
    }

    @PostMapping("/advisers")
    public AcademicAdviserJpa addAcademicAdviser(@RequestBody AcademicAdviserJpa academicAdviserJpa){
        return academicAdviserJpaRepository.save(academicAdviserJpa);
    }

}
