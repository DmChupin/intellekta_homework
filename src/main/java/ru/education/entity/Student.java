package ru.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class Student {

    public static String TYPE_NAME = "Студент";

    @Id
    @Column(name = "id", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_student_id_seq")
    //@SequenceGenerator(name = "student_student_id_seq", sequenceName = "student_student_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "academic_adviser", referencedColumnName = "id")
    private AcademicAdviser academicAdviser;

    public Student(Long id, String name, String surname, String patronymic, AcademicAdviser academicAdviser) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.academicAdviser = academicAdviser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public AcademicAdviser getAcademicAdviser() {
        return academicAdviser;
    }

    public void setAcademicAdviser(AcademicAdviser academicAdviser) {
        this.academicAdviser = academicAdviser;
    }
}
