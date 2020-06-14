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
import ru.education.jpa.AcademicAdviserJpaRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class AcademicAdviserRepositoryTest {

    @Autowired
    private AcademicAdviserJpaRepository academicAdviserJpaRepository;

    @Test
    public void findAllTest() {
        List<AcademicAdviserJpa> academicAdviserJpas = academicAdviserJpaRepository.findAll();
        Assert.assertEquals(academicAdviserJpas.size(), 6);
    }

    @Before
    public void createAdviserTest() {

        AcademicAdviserJpa academicAdviserJpa = new AcademicAdviserJpa(7,"testName", "testSurname", "testPatronymic");
        academicAdviserJpaRepository.save(academicAdviserJpa);

    }

    @Test
    public void findAdviserByNameTest(){
        List<AcademicAdviserJpa> academicAdviserJpas = academicAdviserJpaRepository.findByName("testName");
        Assert.assertNotNull(academicAdviserJpas);
        Assert.assertEquals(academicAdviserJpas.size(), 1);
    }

    @After
    public void deleteAdviserTest() {
        academicAdviserJpaRepository.deleteById(7L);
        List<AcademicAdviserJpa> academicAdviserJpas = academicAdviserJpaRepository.findAll();
        Assert.assertNotNull(academicAdviserJpas);
        Assert.assertEquals(academicAdviserJpas.size(), 5);
    }

}
