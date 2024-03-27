package rs.ac.ni.pmf.web.students.model.mappers;

import org.springframework.stereotype.Component;
import rs.ac.ni.pmf.web.students.model.dto.StudentDTO;
import rs.ac.ni.pmf.web.students.model.entity.StudentEntity;
@Component
public class StudentsMapper {
    public static StudentDTO toDto(final StudentEntity studentEntity) {
        return StudentDTO.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .yearOfStudy(studentEntity.getYearOfStudy())
                .build();
    }
    public static StudentEntity toEntity(final StudentDTO studentDTO) {
        return StudentEntity.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .yearOfStudy(studentDTO.getYearOfStudy())
                .build();
    }
}
