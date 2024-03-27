package rs.ac.ni.pmf.web.students.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.ni.pmf.web.students.exceptions.NoStudentWithSuchId;
import rs.ac.ni.pmf.web.students.model.dto.StudentDTO;
import rs.ac.ni.pmf.web.students.repository.StudentsRepository;

import java.util.List;

@Service
public class StudentsService {
    public List<StudentDTO> getAll() {

       return StudentsRepository.studentsRepository;

    }
    public StudentDTO findStudentByIndex(final int id) {
        return StudentsRepository.studentsRepository.stream()
                .filter(studentDTO -> studentDTO.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoStudentWithSuchId(id));
    }
    public StudentDTO save(StudentDTO studentDTO) {

       StudentsRepository.studentsRepository.add(studentDTO);
       return studentDTO;

    }
    public StudentDTO remove(Integer id) {

        StudentDTO studentDTOToRemove = findStudentByIndex(id);
        StudentsRepository.studentsRepository.remove(studentDTOToRemove);
        return studentDTOToRemove;
    }

    public StudentDTO update(StudentDTO studentDTO, int id) {
        StudentDTO studentDTOToReplace = findStudentByIndex(id);
        studentDTOToReplace.setName(studentDTO.getName());
        studentDTOToReplace.setYearOfStudy(studentDTO.getYearOfStudy());
        return studentDTO;
    }

}