package ru.education.service.impl;

import org.springframework.stereotype.Service;
import ru.education.entity.AcademicAdviser;
import ru.education.entity.Student;
import ru.education.exceptions.EntityAlreadyExistsException;
import ru.education.exceptions.EntityHasDetailException;
import ru.education.exceptions.EntityIllegalArgumentException;
import ru.education.exceptions.EntityNotFoundException;
import ru.education.jpa.AcademicAdviserRepository;
import ru.education.jpa.StudentRepository;
import ru.education.service.AcademicAdviserService;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultAcademicAdviserService implements AcademicAdviserService {

    private final AcademicAdviserRepository academicAdviserRepository;

    private final StudentRepository studentRepository;

    public DefaultAcademicAdviserService(AcademicAdviserRepository academicAdviserRepository, StudentRepository studentRepository) {
        this.academicAdviserRepository = academicAdviserRepository;
        this.studentRepository = studentRepository;
    }

    public List<AcademicAdviser> findAll() {
        return academicAdviserRepository.findAll();
    }

    public AcademicAdviser findById(Object id) {
        Optional<AcademicAdviser> academicAdviser;
        if (id == null){
            throw new EntityIllegalArgumentException("Идентификатор не может быть null");
        }
        Long parsedId;
        try {
            parsedId = Long.valueOf(id.toString());
        } catch (NumberFormatException e) {
            throw new EntityIllegalArgumentException(String.format("Не удалось преобразовать идентификатор к нужному типу ошибки, текст ошибки: %s",e));
        }
        academicAdviser = academicAdviserRepository.findById(parsedId);
        if (!academicAdviser.isPresent()){
            throw new EntityNotFoundException(AcademicAdviser.TYPE_NAME, parsedId);
        }

        return academicAdviser.get();
    }

    public AcademicAdviser create(AcademicAdviser academicAdviser) {
        if (academicAdviser == null){
            throw new EntityIllegalArgumentException("Создаваемый объект не может быть null");
        }
        if(academicAdviser.getId() == null) {
            throw new EntityIllegalArgumentException("Идентификатор не может быть null");
        }
        if(academicAdviser.getName() == null) {
            throw new EntityIllegalArgumentException("Имя не может быть null");
        }
        if(academicAdviser.getSurname() == null) {
            throw new EntityIllegalArgumentException("Фамилия не может быть null");
        }

        Optional<AcademicAdviser> existedAdviser = academicAdviserRepository.findById(academicAdviser.getId());
        if(existedAdviser.isPresent()){
            throw new EntityAlreadyExistsException(AcademicAdviser.TYPE_NAME, academicAdviser.getId());
        }
        return academicAdviserRepository.save(academicAdviser);
    }

    @Override
    public AcademicAdviser update(AcademicAdviser academicAdviser) {
        if (academicAdviser == null){
            throw new EntityIllegalArgumentException("Создаваемый объект не может быть null");
        }
        if(academicAdviser.getId() == null) {
            throw new EntityIllegalArgumentException("Идентификатор не может быть null");
        }
        if(academicAdviser.getName() == null) {
            throw new EntityIllegalArgumentException("Имя не может быть null");
        }
        if(academicAdviser.getSurname() == null) {
            throw new EntityIllegalArgumentException("Фамилия не может быть null");
        }

        Optional<AcademicAdviser> existedAdviser = academicAdviserRepository.findById(academicAdviser.getId());
        if(!existedAdviser.isPresent()){
            throw new EntityNotFoundException(AcademicAdviser.TYPE_NAME, academicAdviser.getId());
        }
        return academicAdviserRepository.save(academicAdviser);
    }

    public void delete(Object id) {
        AcademicAdviser academicAdviser = findById(id);
        List<Student> students = studentRepository.findByAcademicAdviser(academicAdviser);
        if (students.size() > 0) {
            throw new EntityHasDetailException(Student.TYPE_NAME, academicAdviser.getId());
        }
        academicAdviserRepository.delete(academicAdviser);
    }
}
