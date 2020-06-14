package ru.education.service;

import org.springframework.stereotype.Service;
import ru.education.entity.Student;
import ru.education.exceptions.EntityAlreadyExistsException;
import ru.education.exceptions.EntityConflictException;
import ru.education.exceptions.EntityIllegalArgumentException;
import ru.education.exceptions.EntityNotFoundException;
import ru.education.jpa.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Object id) {
        Optional<Student> student;
        if (id == null){
            throw new EntityIllegalArgumentException("Идентификатор не может быть null");
        }
        Long parsedId;
        try {
            parsedId = Long.valueOf(id.toString());
        } catch (NumberFormatException e) {
            throw new EntityIllegalArgumentException(String.format("Не удалось преобразовать идентификатор к нужному типу ошибки, текст ошибки: %s",e));
        }
        student = studentRepository.findById(parsedId);
        if (!student.isPresent()){
            throw new EntityNotFoundException(Student.TYPE_NAME, parsedId);
        }

        return student.get();
    }

    public Student create(Student student) {
        if (student == null){
            throw new EntityIllegalArgumentException("Создаваемый объект не может быть null");
        }
        if(student.getId() == null) {
            throw new EntityIllegalArgumentException("Идентификатор не может быть null");
        }
        if(student.getName() == null) {
            throw new EntityIllegalArgumentException("Имя не может быть null");
        }
        if(student.getSurname() == null) {
            throw new EntityIllegalArgumentException("Фамилия не может быть null");
        }

        List<Student> students = studentRepository.findByNameAndSurnameAndPatronymic(student.getName(), student.getSurname(), student.getPatronymic());
        if(students.size() > 0){
            throw new EntityConflictException(String.format("В системе уже имеются студенты с заданным ФИО: %s %s %s", student.getSurname(), student.getName(), student.getPatronymic() ));
        }

        Optional<Student> existedAdviser = studentRepository.findById(student.getId());
        if(existedAdviser.isPresent()){
            throw new EntityAlreadyExistsException(Student.TYPE_NAME, student.getId());
        }
        return studentRepository.save(student);
    }

    public void delete(Object id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }
}
