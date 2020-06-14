package repository;

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
import ru.education.entity.AcademicAdviser;
import ru.education.entity.Student;
import ru.education.jpa.AcademicAdviserRepository;
import ru.education.jpa.StudentRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AcademicAdviserRepository academicAdviserRepository;

    @Test
    public void findAllTest() {
        List<Student> students = studentRepository.findAll();
        Assert.assertEquals(students.size(), 8);
    }

    @Before
    public void createStudentTest() {
        AcademicAdviser academicAdviser = academicAdviserRepository.findById(1L).get();

        Student student = new Student(12L,"testName", "testSurname", "testPatronymic", null);
        studentRepository.save(student);

    }

    @Test
    public void findStudentByNameTest(){
        List<Student> students = studentRepository.findByName("testName");
        Assert.assertNotNull(students);
        Assert.assertEquals(students.size(), 1);
    }

    @After
    public void deleteStudentTest() {
        studentRepository.deleteById(12L);
        List<Student> students = studentRepository.findAll();
        Assert.assertNotNull(students);
        Assert.assertEquals(students.size(), 7);
    }
}
