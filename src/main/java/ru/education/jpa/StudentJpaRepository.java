package ru.education.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.entity.StudentJpa;

public interface StudentJpaRepository extends JpaRepository<StudentJpa, Long> {
}
