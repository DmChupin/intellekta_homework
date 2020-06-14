package ru.education.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.entity.AcademicAdviser;
import ru.education.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    List<Student> findByAcademicAdviser(AcademicAdviser academicAdviser);

    List<Student> findByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}
