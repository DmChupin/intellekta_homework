package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.education.controllers.AcademicAdviserController;
import ru.education.entity.AcademicAdviser;
import service.mock.MockAcademicAdviserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AcademicAdviserController.class, MockAcademicAdviserService.class})
public class AcademicAdviserControllerTest {

    @Autowired
    private AcademicAdviserController academicAdviserController;

    private MockMvc mockMvc;

    private final static String URL = "http://localhost:8080/api/v1/adviser";

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(academicAdviserController).build();
    }

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get(URL))
                .andExpect(status().isOk());
    }

    @Test
    public void createTest() throws Exception {
        AcademicAdviser academicAdviser = new AcademicAdviser(8L, "nameMock", "surnameMock", "patronymicMock");
        String requestJson = mapper.writeValueAsString(academicAdviser);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                   .andExpect(status().isCreated());
    }

    @Test
    public void updateTest() throws Exception {
        AcademicAdviser academicAdviser = new AcademicAdviser(1L, "nameMock", "surnameMock", "patronymicMock");
        String requestJson = mapper.writeValueAsString(academicAdviser);
        mockMvc.perform(put(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(get(URL + "/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(delete(URL + "/1"))
                .andExpect(status().isNoContent());
    }

}
