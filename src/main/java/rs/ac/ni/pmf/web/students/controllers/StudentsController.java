package rs.ac.ni.pmf.web.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.ni.pmf.web.students.exceptions.NoStudentWithSuchId;
import rs.ac.ni.pmf.web.students.model.dto.StudentDTO;
import rs.ac.ni.pmf.web.students.repository.StudentsRepository;

import java.util.List;
@RestController
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
public class StudentsController {


    /*
        GET http://localhost:8080/students
         */
    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {
        return StudentsRepository.studentsRepository;
    }
    @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable int id) {
        return findStudentById(id);
    }
    @PostMapping("/students")
    public StudentDTO createStudent(@RequestBody StudentDTO student) {
        StudentsRepository.studentsRepository.add(student);
        return student;
    }
    @PutMapping("/students/{id}")
    public StudentDTO update(@PathVariable int id, @RequestBody StudentDTO updatedStudent) {
        StudentDTO studentToUpdate = StudentsRepository.studentsRepository.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoStudentWithSuchId(id));
        studentToUpdate.setName(updatedStudent.getName());
        studentToUpdate.setYearOfStudy(updatedStudent.getYearOfStudy());
        return updatedStudent;
    }
    @DeleteMapping("/students/{id}")
    public StudentDTO remove(@PathVariable int id) {
        StudentDTO student = findStudentById(id);
        StudentsRepository.studentsRepository.remove(student);
        return student;
    }


    private StudentDTO findStudentById(int id) {
        return StudentsRepository.studentsRepository.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoStudentWithSuchId(id));
    }



}
