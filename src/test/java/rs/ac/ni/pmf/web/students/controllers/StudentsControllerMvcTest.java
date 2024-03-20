package rs.ac.ni.pmf.web.students.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class StudentsControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Pera Peric\",\"yearOfStudy\":4},{\"id\":2,\"name\":\"Joca Jocic\",\"yearOfStudy\":2},{\"id\":3,\"name\":\"Jovana Jovanovic\",\"yearOfStudy\":3}]"));
    }

}