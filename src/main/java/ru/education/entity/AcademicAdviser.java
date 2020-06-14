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
public class AcademicAdviser {

    public static String TYPE_NAME = "Научный руководитель";

    @Id
    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_adviser_id_seq")
//    @SequenceGenerator(name = "academic_adviser_id_seq", sequenceName = "academic_adviser_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    public AcademicAdviser(Long id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
