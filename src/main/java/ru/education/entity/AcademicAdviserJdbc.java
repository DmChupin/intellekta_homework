package ru.education.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademicAdviserJdbc {

    private long id;

    private String name;

    private String surname;

    private String patronymic;

    public AcademicAdviserJdbc(long id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }
}
