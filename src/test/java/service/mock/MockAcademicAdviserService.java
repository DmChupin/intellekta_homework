package service.mock;

import org.springframework.stereotype.Service;
import ru.education.entity.AcademicAdviser;
import ru.education.service.AcademicAdviserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockAcademicAdviserService implements AcademicAdviserService {

    @Override
    public List<AcademicAdviser> findAll() {
        return new ArrayList<>();
    }

    @Override
    public AcademicAdviser findById(Object id) {
        return new AcademicAdviser(Long.valueOf(id.toString()), "testName", "testSurname", "testPatronimyc");
    }

    @Override
    public AcademicAdviser create(AcademicAdviser academicAdviser) {
        return academicAdviser;
    }

    @Override
    public AcademicAdviser update(AcademicAdviser academicAdviser) {
        return academicAdviser;
    }

    @Override
    public void delete(Object id) {

    }
}
