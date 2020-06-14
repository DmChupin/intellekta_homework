package ru.education.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class StudentJpa {

    @Id
    @Column(name = "id", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_student_id_seq")
    //@SequenceGenerator(name = "student_student_id_seq", sequenceName = "student_student_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "academic_adviser", referencedColumnName = "id")
    private AcademicAdviserJpa academicAdviserJpa;

    public StudentJpa(long id, String name, String surname, String patronymic, AcademicAdviserJpa academicAdviserJpa) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.academicAdviserJpa = academicAdviserJpa;
    }
}
