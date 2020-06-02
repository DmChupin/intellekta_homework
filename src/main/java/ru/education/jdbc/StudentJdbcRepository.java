package ru.education.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.education.entity.StudentJdbc;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StudentJdbc> getStudents() {
        return jdbcTemplate.query("SELECT * FROM public.student", (rs, rowNum) ->
                new StudentJdbc(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("patronymic"),
                        rs.getLong("academic_adviser")
                ));
    }

    public Optional<StudentJdbc> getStudentById(Long id) {
        return jdbcTemplate.queryForObject(String.format("SELECT * FROM public.student WHERE id = %s", id),
                (rs, rowNum) ->
                Optional.of(new StudentJdbc(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("patronymic"),
                        rs.getLong("academic_adviser")
                )));
    }

    public int addStudents(StudentJdbc studentJdbc) {
        return jdbcTemplate.update(
            "INSERT INTO public.student (name, surname, patronymic, academic_adviser) " +
                    "values (?, ?, ?, ?)",
                    studentJdbc.getName(), studentJdbc.getSurname(), studentJdbc.getPatronymic(), studentJdbc.getAcademicAdviser()
        );
    }
}
