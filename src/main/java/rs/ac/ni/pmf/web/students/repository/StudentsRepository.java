package rs.ac.ni.pmf.web.students.repository;

import rs.ac.ni.pmf.web.students.model.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepository {
    public static List<StudentDTO> studentsRepository = new ArrayList<>();
    static {
        studentsRepository.add(StudentDTO.builder().id(1).name("Pera Peric").yearOfStudy(4).build());
        studentsRepository.add(StudentDTO.builder().id(2).name("Joca Jocic").yearOfStudy(2).build());
        studentsRepository.add(StudentDTO.builder().id(3).name("Jovana Jovanovic").yearOfStudy(3).build());
    }

}
