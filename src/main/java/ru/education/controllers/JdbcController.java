package ru.education.controllers;

import org.springframework.web.bind.annotation.*;
import ru.education.entity.AcademicAdviserJdbc;
import ru.education.entity.StudentJdbc;
import ru.education.jdbc.AcademicAdviserJdbcRepository;
import ru.education.jdbc.StudentJdbcRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/jdbc")
public class JdbcController {

    private final AcademicAdviserJdbcRepository academicAdviserJdbcRepository;

    private final StudentJdbcRepository studentJdbcRepository;

    public JdbcController(AcademicAdviserJdbcRepository academicAdviserJdbcRepository, StudentJdbcRepository studentJdbcRepository) {
        this.academicAdviserJdbcRepository = academicAdviserJdbcRepository;
        this.studentJdbcRepository = studentJdbcRepository;
    }

    @GetMapping("/students")
    public List<StudentJdbc> getStudents(){
        return studentJdbcRepository.getStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<StudentJdbc> getStudent(@PathVariable("id") Long id) {
        return  studentJdbcRepository.getStudentById(id);
    }

    @PostMapping("/students")
    public int addStudents(@RequestBody StudentJdbc studentJdbc){
        return studentJdbcRepository.addStudents(studentJdbc);
    }

    @GetMapping("/advisers")
    public List<AcademicAdviserJdbc> getAcademicAdvisers(){
        return  academicAdviserJdbcRepository.getAcademicAdvisers();
    }

    @GetMapping("/advisers/{id}")
    public Optional<AcademicAdviserJdbc> getAcademicAdviser(@PathVariable("id") Long id) {
        return  academicAdviserJdbcRepository.getAcademicAdviserByID(id);
    }

    @PostMapping("/advisers")
    public int addAcademicAdviser(@RequestBody AcademicAdviserJdbc academicAdviserJdbc){
        return academicAdviserJdbcRepository.addAcademicAdviser(academicAdviserJdbc);
    }

}
