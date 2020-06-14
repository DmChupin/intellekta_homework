DROP TABLE IF EXISTS academic_adviser;
DROP TABLE IF EXISTS student;

-- auto-generated definition
create table academic_adviser
(
    id         bigserial not null
        constraint academic_adviser_pk
            primary key,
    surname    text      not null,
    name       text      not null,
    patronymic text
);

create unique index academic_adviser_id_uindex
    on academic_adviser (id);



-- auto-generated definition
create table student
(
    id               bigserial not null
        constraint student_pk
            primary key,
    name             text      not null,
    surname          text      not null,
    patronymic       text,
    academic_adviser bigint
);

create unique index student_student_id_uindex
    on student (id);

