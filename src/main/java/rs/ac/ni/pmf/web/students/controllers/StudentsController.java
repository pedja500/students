package rs.ac.ni.pmf.web.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.ac.ni.pmf.web.students.exceptions.NoStudentWithSuchId;
import rs.ac.ni.pmf.web.students.model.dto.StudentDTO;
import rs.ac.ni.pmf.web.students.repository.StudentsRepository;
import rs.ac.ni.pmf.web.students.service.StudentsService;

import java.util.List;
@RestController
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
public class StudentsController {


    /*
        GET http://localhost:8080/students
         */
    private final StudentsService studentsService;
    @Autowired
    public StudentsController(StudentsService studentsService) {

        this.studentsService = studentsService;
    }

    /*
    GET http://localhost:8080/students
     */
    @GetMapping("/students")
    public List<StudentDTO> allStudents() {
       return studentsService.getAll();
    }

    /*
        GET http://localhost:8080/student/id
        */
    @GetMapping("/students/{index}")
    public StudentDTO getStudentByIndex(@PathVariable("index") final int id) {
        return studentsService.findStudentByIndex(id);
    }
    //@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
    @GetMapping("/students-xml/{index}")
    public StudentDTO getStudentById(@PathVariable final int index) {
        return  studentsService.findStudentByIndex(index);
    }
    @PostMapping("/students")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentsService.save(studentDTO);
    }
    @PutMapping("/students/{id}")
    public StudentDTO update(@RequestBody StudentDTO studentDTO, @PathVariable("id") int id) {
        return studentsService.update(studentDTO,id);
    }
    @DeleteMapping("/students/{id}")
    public StudentDTO remove(@PathVariable int id) {
        return studentsService.remove(id);
    }



}
