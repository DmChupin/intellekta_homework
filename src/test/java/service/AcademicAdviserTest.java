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
import ru.education.service.impl.DefaultAcademicAdviserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class AcademicAdviserTest {

    @Autowired
    private DefaultAcademicAdviserService defaultAcademicAdviserService;

    @Test
    public void findAllTest() {
        List<AcademicAdviser> academicAdvisers = defaultAcademicAdviserService.findAll();
        Assert.assertEquals(academicAdvisers.size(), 6);
    }

    //CREATE START

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullAcademicAdviserException() {
        defaultAcademicAdviserService.create(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullIdAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(null, "name", "surname", "patronymic");
        defaultAcademicAdviserService.create(academicAdviser);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullNameAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(22L, null, "surname", "patronymic");
        defaultAcademicAdviserService.create(academicAdviser);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void createNullSurnameAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(22L, "name", null, "patronymic");
        defaultAcademicAdviserService.create(academicAdviser);
    }


    @Test(expected = EntityAlreadyExistsException.class)
    public  void createExistedAcademicAdviserException() {
        AcademicAdviser academicAdviser = new AcademicAdviser(1L, "name", "surname", "patronymic");
        defaultAcademicAdviserService.create(academicAdviser);
    }

    @Before
    public void CreateAcademicAdviserTest() {
        AcademicAdviser academicAdviser = new AcademicAdviser(8L, "name", "surname", "patronymic");
        defaultAcademicAdviserService.create(academicAdviser);
    }
    //CREATE END

    //FINDBYID START

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindAdviserByNullIdException() {
        defaultAcademicAdviserService.findById(null);
    }

    @Test(expected = EntityIllegalArgumentException.class)
    public void FindAdviserByIllegalFormatIdException() {
        defaultAcademicAdviserService.findById("id");
    }

    @Test(expected = EntityNotFoundException.class)
    public void FindAdviserByNotExistedIdException() {
        defaultAcademicAdviserService.findById(12313);
    }

    @Test
    public void FindAdviserByIdTest() {
        AcademicAdviser academicAdviser = defaultAcademicAdviserService.findById(1L);
        Assert.assertNotNull(academicAdviser);
    }
    //FIND BY ID END

    //DELETE BY ID START

    @Test(expected = EntityHasDetailException.class)
    public void deleteAdviserWithStudentsByIdException() {
        defaultAcademicAdviserService.delete(1);
    }

    @After
    public void deleteAdviserByIdTest() {
        defaultAcademicAdviserService.delete(8);
        List<AcademicAdviser> academicAdvisers = defaultAcademicAdviserService.findAll();
        Assert.assertEquals(academicAdvisers.size(), 5);
    }

}
