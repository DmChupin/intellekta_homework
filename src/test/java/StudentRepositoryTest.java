import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.education.entity.AcademicAdviserJpa;
import ru.education.entity.StudentJpa;
import ru.education.jpa.AcademicAdviserJpaRepository;
import ru.education.jpa.StudentJpaRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class StudentRepositoryTest {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Autowired
    private AcademicAdviserJpaRepository academicAdviserJpaRepository;

    @Test
    public void findAllTest() {
        List<StudentJpa> studentJpas = studentJpaRepository.findAll();
        Assert.assertEquals(studentJpas.size(), 8);
    }

    @Before
    public void createStudentTest() {
        AcademicAdviserJpa academicAdviserJpa = academicAdviserJpaRepository.findById(1L).get();

        StudentJpa studentJpa = new StudentJpa(12,"testName", "testSurname", "testPatronymic", null);
        studentJpaRepository.save(studentJpa);

    }

    @Test
    public void findStudentByNameTest(){
        List<StudentJpa> studentJpas = studentJpaRepository.findByName("testName");
        Assert.assertNotNull(studentJpas);
        Assert.assertEquals(studentJpas.size(), 1);
    }

    @After
    public void deleteStudentTest() {
        studentJpaRepository.deleteById(12L);
        List<StudentJpa> studentJpas = studentJpaRepository.findAll();
        Assert.assertNotNull(studentJpas);
        Assert.assertEquals(studentJpas.size(), 7);
    }
}
