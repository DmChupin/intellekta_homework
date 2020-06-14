package ru.education.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.entity.AcademicAdviserJpa;

import java.util.List;

public interface AcademicAdviserJpaRepository extends JpaRepository<AcademicAdviserJpa, Long> {

    List<AcademicAdviserJpa> findByName(String name);
}
