package service;

import config.TestConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.education.entity.Student;
import ru.education.exceptions.*;
import ru.education.service.StudentService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void findAllTest() {
        List<Student>  students = studentService.findAll();
        Assert.assertEquals(students.size(), 8);
    }

    //CREATE START

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullStudentException() {
        studentService.create(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullIdStudentException() {
        Student student = new Student(null, "name", "surname", "patronymic", null);
        studentService.create(student);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullNameStudentException() {
        Student student = new Student(22L, null, "surname", "patronymic", null);
        studentService.create(student);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullSurnameStudentException() {
        Student student = new Student(22L, "name", null, "patronymic", null);
        studentService.create(student);
    }


    @Test(expected = EntityAlreadyExistsException.class)
    public  void createExistedStudentException() {
        Student student = new Student(1L, "name1", "surname", "patronymic", null);
        studentService.create(student);
    }

    @Test(expected = EntityConflictException.class)
    public void createExistedFioStudentException() {
        Student student = new Student(151L, "name", "surname", "patronymic", null);
        studentService.create(student);
    }

    @Before
    public void CreateStudentTest() {
        Student student = new Student(15L, "name", "surname", "patronymic", null);
        studentService.create(student);
    }
    //CREATE END

    //FINDBYID START

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindStudentByNullIdException() {
        studentService.findById(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindStudentByIllegalFormatIdException() {
        studentService.findById("id");
    }

    @Test(expected = EntityNotFoundException.class)
    public void FindStudentByNotExistedIdException() {
        studentService.findById(12313);
    }

    @Test
    public void FindStudentByIdTest() {
        Student student = studentService.findById(1L);
        Assert.assertNotNull(student);
    }
    //FIND BY ID END

    //DELETE BY ID START

    @After
    public void deletStudentByIdTest() {
        studentService.delete(15);
        List<Student> students = studentService.findAll();
        Assert.assertEquals(students.size(), 7);
    }
}
