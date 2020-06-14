package ru.education.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.entity.AcademicAdviser;

import java.util.List;

public interface AcademicAdviserRepository extends JpaRepository<AcademicAdviser, Long> {

    List<AcademicAdviser> findByName(String name);
}
