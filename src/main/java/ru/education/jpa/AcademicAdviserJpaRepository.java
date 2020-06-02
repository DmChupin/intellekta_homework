package ru.education.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.entity.AcademicAdviserJpa;

public interface AcademicAdviserJpaRepository extends JpaRepository<AcademicAdviserJpa, Long> {
}
