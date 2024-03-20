package rs.ac.ni.pmf.web.students.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    int id;
    String name;
    int yearOfStudy;
}
