package ru.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "academic_adviser")
@NoArgsConstructor
@Getter
@Setter
public class AcademicAdviserJpa {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_adviser_id_seq")
    @SequenceGenerator(name = "academic_adviser_id_seq", sequenceName = "academic_adviser_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    public AcademicAdviserJpa(long id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }
}
