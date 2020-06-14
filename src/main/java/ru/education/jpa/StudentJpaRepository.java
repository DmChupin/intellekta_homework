package ru.education.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.entity.StudentJpa;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<StudentJpa, Long> {

    List<StudentJpa> findByName(String name);
}
