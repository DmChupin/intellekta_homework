package ru.education.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentJdbc {

    private long id;

    private String name;

    private String surname;

    private String patronymic;

    private long academicAdviser;

    public StudentJdbc(long id, String name, String surname, String patronymic, long academicAdviser) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.academicAdviser = academicAdviser;
    }
}
