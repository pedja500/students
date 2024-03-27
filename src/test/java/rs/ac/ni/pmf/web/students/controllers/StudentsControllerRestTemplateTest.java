package rs.ac.ni.pmf.web.students.controllers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rs.ac.ni.pmf.web.students.model.dto.StudentDTO;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentsControllerRestTemplateTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void shouldGetStudentById() {
        final ResponseEntity<StudentDTO> responseEntity = testRestTemplate.getForEntity("http://localhost:"+ port +"/students/1", StudentDTO.class);
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(1);
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo((HttpStatus.OK));
    }
    @Test
    public void shouldAddStudent() {
        final ResponseEntity<StudentDTO> responseEntity = testRestTemplate.postForEntity("http://localhost:"+ port +"/students", StudentDTO.builder().id(3).yearOfStudy(3).name("Jovana Jovanovic").build(), StudentDTO.class);

        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(3);
        Assertions.assertThat(responseEntity.getBody().getName()).isEqualTo("Jovana Jovanovic");
        Assertions.assertThat(responseEntity.getBody().getYearOfStudy()).isEqualTo(3);


    }

}
