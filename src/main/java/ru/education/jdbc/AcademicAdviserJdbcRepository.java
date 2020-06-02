package ru.education.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.education.entity.AcademicAdviserJdbc;

import java.util.List;
import java.util.Optional;

@Repository
public class AcademicAdviserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public AcademicAdviserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AcademicAdviserJdbc> getAcademicAdvisers() {
        return jdbcTemplate.query("SELECT * FROM public.academic_adviser", (rs, rowNum) ->
                new AcademicAdviserJdbc(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("patronymic")
                ));

    }

    public Optional<AcademicAdviserJdbc> getAcademicAdviserByID(Long id) {
        return jdbcTemplate.queryForObject(String.format("SELECT * FROM public.academic_adviser WHERE id = %s", id),
                (rs, rowNum) ->
                        Optional.of(new AcademicAdviserJdbc(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getString("patronymic")
                        )));
    }

    public int addAcademicAdviser(AcademicAdviserJdbc academicAdviserJdbc) {
        return jdbcTemplate.update(
                "INSERT INTO public.academic_adviser (name, surname, patronymic) " +
                        "values (?, ?, ?)",
                academicAdviserJdbc.getName(), academicAdviserJdbc.getSurname(), academicAdviserJdbc.getPatronymic()
        );
    }
}
