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
import ru.education.service.impl.DefaultStudentService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class StudentTest {

    @Autowired
    private DefaultStudentService defaultStudentService;

    @Test
    public void findAllTest() {
        List<Student>  students = defaultStudentService.findAll();
        Assert.assertEquals(students.size(), 8);
    }

    //CREATE START

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullStudentException() {
        defaultStudentService.create(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullIdStudentException() {
        Student student = new Student(null, "name", "surname", "patronymic", null);
        defaultStudentService.create(student);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullNameStudentException() {
        Student student = new Student(22L, null, "surname", "patronymic", null);
        defaultStudentService.create(student);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullSurnameStudentException() {
        Student student = new Student(22L, "name", null, "patronymic", null);
        defaultStudentService.create(student);
    }


    @Test(expected = EntityAlreadyExistsException.class)
    public  void createExistedStudentException() {
        Student student = new Student(1L, "name1", "surname", "patronymic", null);
        defaultStudentService.create(student);
    }

    @Test(expected = EntityConflictException.class)
    public void createExistedFioStudentException() {
        Student student = new Student(151L, "name", "surname", "patronymic", null);
        defaultStudentService.create(student);
    }

    @Before
    public void CreateStudentTest() {
        Student student = new Student(15L, "name", "surname", "patronymic", null);
        defaultStudentService.create(student);
    }
    //CREATE END

    //FINDBYID START

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindStudentByNullIdException() {
        defaultStudentService.findById(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindStudentByIllegalFormatIdException() {
        defaultStudentService.findById("id");
    }

    @Test(expected = EntityNotFoundException.class)
    public void FindStudentByNotExistedIdException() {
        defaultStudentService.findById(12313);
    }

    @Test
    public void FindStudentByIdTest() {
        Student student = defaultStudentService.findById(1L);
        Assert.assertNotNull(student);
    }
    //FIND BY ID END

    //DELETE BY ID START

    @After
    public void deletStudentByIdTest() {
        defaultStudentService.delete(15);
        List<Student> students = defaultStudentService.findAll();
        Assert.assertEquals(students.size(), 7);
    }
}
