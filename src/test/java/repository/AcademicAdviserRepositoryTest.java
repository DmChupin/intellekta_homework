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
import ru.education.jpa.AcademicAdviserRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class AcademicAdviserRepositoryTest {

    @Autowired
    private AcademicAdviserRepository academicAdviserRepository;

    @Test
    public void findAllTest() {
        List<AcademicAdviser> academicAdvisers = academicAdviserRepository.findAll();
        Assert.assertEquals(academicAdvisers.size(), 6);
    }

    @Before
    public void createAdviserTest() {

        AcademicAdviser academicAdviser = new AcademicAdviser(7L,"testName", "testSurname", "testPatronymic");
        academicAdviserRepository.save(academicAdviser);

    }

    @Test
    public void findAdviserByNameTest(){
        List<AcademicAdviser> academicAdvisers = academicAdviserRepository.findByName("testName");
        Assert.assertNotNull(academicAdvisers);
        Assert.assertEquals(academicAdvisers.size(), 1);
    }

    @After
    public void deleteAdviserTest() {
        academicAdviserRepository.deleteById(7L);
        List<AcademicAdviser> academicAdvisers = academicAdviserRepository.findAll();
        Assert.assertNotNull(academicAdvisers);
        Assert.assertEquals(academicAdvisers.size(), 5);
    }

}
