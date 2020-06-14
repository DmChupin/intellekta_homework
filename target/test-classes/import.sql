INSERT INTO public.academic_adviser (id, surname, name, patronymic) VALUES (1, 'Русаков', 'Сергей', 'Владимирович');
INSERT INTO public.academic_adviser (id, surname, name, patronymic) VALUES (2, 'Ясницкий', 'Леонид', 'Нахимович');
INSERT INTO public.academic_adviser (id, surname, name, patronymic) VALUES (3, 'Гусев', 'Андрей', 'Леонидович');
INSERT INTO public.academic_adviser (id, surname, name, patronymic) VALUES (4, 'AdviserJpaIns', 'AdviserJpaIns', 'AdviserJpaIns');
INSERT INTO public.academic_adviser (id, surname, name, patronymic) VALUES (5, 'AdviserJdbcIns', 'AdviserJdbcIns', 'AdviserJdbcIns');

INSERT INTO public.student (id, name, surname, patronymic, academic_adviser) VALUES (1, 'Чупин', 'Дмитрий', 'Алексеевич', 1);
INSERT INTO public.student (id, name, surname, patronymic, academic_adviser) VALUES (2, 'Чибисов', 'Андрей', 'Васильевич', 1);
INSERT INTO public.student (id, name, surname, patronymic, academic_adviser) VALUES (3, 'Лашко', 'Никита', 'Дмитриевич', 2);
INSERT INTO public.student (id, name, surname, patronymic, academic_adviser) VALUES (4, 'Тверяков', 'Валентин', 'Михайлович', 3);
INSERT INTO public.student (id, name, surname, patronymic) VALUES (5, 'Гилязов', 'Игорь', 'Гаязович');
INSERT INTO public.student (id, name, surname, patronymic, academic_adviser) VALUES (6, 'JpaIns', 'JpaIns', 'JpaIns', 2);
INSERT INTO public.student (id, name, surname, patronymic, academic_adviser) VALUES (18, 'JdbcIns', 'JdbcIns', 'JdbcIns', 3);