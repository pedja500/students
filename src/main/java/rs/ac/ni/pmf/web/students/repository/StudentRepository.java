package rs.ac.ni.pmf.web.students.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.ni.pmf.web.students.model.entity.StudentEntity;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {


}
