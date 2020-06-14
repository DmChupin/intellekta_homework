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
import ru.education.entity.AcademicAdviser;
import ru.education.exceptions.EntityAlreadyExistsException;
import ru.education.exceptions.EntityHasDetailException;
import ru.education.exceptions.EntityIllegalArgumentException;
import ru.education.exceptions.EntityNotFoundException;
import ru.education.service.AcademicAdviserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class AcademicAdviserTest {

    @Autowired
    private AcademicAdviserService academicAdviserService;

    @Test
    public void findAllTest() {
        List<AcademicAdviser> academicAdvisers = academicAdviserService.findAll();
        Assert.assertEquals(academicAdvisers.size(), 6);
    }

    //CREATE START

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullAcademicAdviserException() {
        academicAdviserService.create(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullIdAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(null, "name", "surname", "patronymic");
        academicAdviserService.create(academicAdviser);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullNameAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(22L, null, "surname", "patronymic");
        academicAdviserService.create(academicAdviser);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullSurnameAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(22L, "name", null, "patronymic");
        academicAdviserService.create(academicAdviser);
    }


    @Test(expected = EntityAlreadyExistsException.class)
    public  void createExistedAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(1L, "name", "surname", "patronymic");
        academicAdviserService.create(academicAdviser);
    }

    @Before
    public void CreateAcademicAdviserTest() {
        AcademicAdviser academicAdviser = new AcademicAdviser(8L, "name", "surname", "patronymic");
        academicAdviserService.create(academicAdviser);
    }
    //CREATE END

    //FINDBYID START

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindAdviserByNullIdException() {
        academicAdviserService.findById(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindAdviserByIllegalFormatIdException() {
        academicAdviserService.findById("id");
    }

    @Test(expected = EntityNotFoundException.class)
    public void FindAdviserByNotExistedIdException() {
        academicAdviserService.findById(12313);
    }

    @Test
    public void FindAdviserByIdTest() {
        AcademicAdviser academicAdviser = academicAdviserService.findById(1L);
        Assert.assertNotNull(academicAdviser);
    }
    //FIND BY ID END

    //DELETE BY ID START

    @Test(expected = EntityHasDetailException.class)
    public void deleteAdviserWithStudentsByIdException() {
        academicAdviserService.delete(1);
    }

    @After
    public void deleteAdviserByIdTest() {
        academicAdviserService.delete(8);
        List<AcademicAdviser> academicAdvisers = academicAdviserService.findAll();
        Assert.assertEquals(academicAdvisers.size(), 5);
    }

}
