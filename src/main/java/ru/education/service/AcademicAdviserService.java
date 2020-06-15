package ru.education.service;

import ru.education.entity.AcademicAdviser;

import java.util.List;

public interface AcademicAdviserService {

    List<AcademicAdviser> findAll();

    AcademicAdviser findById(Object id);

    AcademicAdviser create(AcademicAdviser academicAdviser);

    AcademicAdviser update(AcademicAdviser academicAdviser);

    void delete(Object id);
}
