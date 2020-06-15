package service.mock;

import org.springframework.stereotype.Service;
import ru.education.entity.Student;
import ru.education.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockStudentService implements StudentService {
    @Override
    public List<Student> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Student findById(Object id) {
        return new Student(Long.valueOf(id.toString()), "testName", "testSurname", "testPatronimyc", null);
    }

    @Override
    public Student create(Student student) {
        return student;
    }

    @Override
    public Student update(Student student) {
        return student;
    }

    @Override
    public void delete(Object id) {

    }
}
