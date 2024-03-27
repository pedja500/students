package rs.ac.ni.pmf.web.students.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.ni.pmf.web.students.exceptions.NoStudentWithSuchId;
import rs.ac.ni.pmf.web.students.model.dto.StudentDTO;
import rs.ac.ni.pmf.web.students.model.entity.StudentEntity;
import rs.ac.ni.pmf.web.students.model.mappers.StudentsMapper;
import rs.ac.ni.pmf.web.students.repository.StudentRepository;
import rs.ac.ni.pmf.web.students.repository.StudentsRepository;

import java.util.List;

@Service
public class StudentsService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentsService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAll() {


        return studentRepository.findAll().stream()
                .map(StudentsMapper::toDto)
                .toList();
//        return StudentsRepository.studentsRepository;

    }

    public StudentDTO findStudentByIndex(final int id) {
        return StudentsRepository.studentsRepository.stream()
                .filter(studentDTO -> studentDTO.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoStudentWithSuchId(id));
    }
    public StudentDTO save(StudentDTO studentDTO) {
        studentRepository.save(StudentsMapper.toEntity(studentDTO));
//        StudentsRepository.studentsRepository.add(studentDTO);
        return studentDTO;
    }

    public StudentDTO remove(Integer id) {
        StudentEntity studentEntity= studentRepository.findById(id).get();
        StudentDTO studentDTO = StudentsMapper.toDto(studentEntity);
        studentRepository.delete(studentEntity);
        return studentDTO;
//        StudentDTO studentDTOToRemove = findStudentByIndex(id);
//        StudentsRepository.studentsRepository.remove(studentDTOToRemove);
//        return studentDTOToRemove;
    }

    public StudentDTO update(StudentDTO studentDTO, int id) {
        StudentEntity studentEntity= studentRepository.findById(id).get();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setYearOfStudy(studentDTO.getYearOfStudy());
        // studentRepository.delete(studentEntity);
        studentRepository.save(studentEntity);
        return studentDTO;
//        StudentDTO studentDTOToReplace = findStudentByIndex(id);
//        studentDTOToReplace.setName(studentDTO.getName());
//        studentDTOToReplace.setYearOfStudy(studentDTO.getYearOfStudy());
//        return studentDTO;
    }

}