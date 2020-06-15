package ru.education.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.education.entity.AcademicAdviser;
import ru.education.service.AcademicAdviserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/adviser")
public class AcademicAdviserController {

    private final AcademicAdviserService academicAdviserService;

    public AcademicAdviserController(AcademicAdviserService academicAdviserService) {
        this.academicAdviserService = academicAdviserService;
    }

    @GetMapping
    public List<AcademicAdviser> findAll() {
        return academicAdviserService.findAll();
    }

    @GetMapping("/{id}")
    public AcademicAdviser findById(@PathVariable String id) {
        return academicAdviserService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcademicAdviser create(@RequestBody AcademicAdviser academicAdviser) {
        return academicAdviserService.create(academicAdviser);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public AcademicAdviser update(@RequestBody AcademicAdviser academicAdviser) {
        return academicAdviserService.update(academicAdviser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        academicAdviserService.delete(id);
    }
}
